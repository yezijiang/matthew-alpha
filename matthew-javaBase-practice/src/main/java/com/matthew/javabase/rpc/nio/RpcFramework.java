package com.matthew.javabase.rpc.nio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-28 16:43
 */
public class RpcFramework {
    //模拟bean工厂，这部分可以通过结合spring实现，也可以自定义bean初始化工厂
    private static Map<String, Object> beanCache = new HashMap<String, Object>();

    static {
        HelloService helloService = new HelloServiceImpl();
        beanCache.put(helloService.getClass().getInterfaces()[0].getName(), helloService);
    }

    public static void export(final Object service,int port) throws Exception {
        if(service == null)
            throw new IllegalArgumentException("service instance is null");
        if(port<=0||port>65535)
            throw new IllegalArgumentException("Invalid port "+port);
        beanCache.put(service.getClass().getInterfaces()[0].getName(), service);
        System.out.println("Export service "+service.getClass().getName()+" on port "+port);
        //通过静态工厂创建一个选择器，
        Selector selector = Selector.open();
        //通过静态广场创建服务端的channel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //设置为非阻塞方式
        ssc.configureBlocking(false);
        //绑定一个端口
        ssc.socket().bind(new InetSocketAddress(port));
        //将这个通信信道注册到选择器上。
        ssc.register(selector,SelectionKey.OP_ACCEPT);
        System.out.println("--->>监听服务启动，端口号："+port+".");
        while (true) {
            int n = selector.select();
            if (n == 0)
                continue;
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel sc = (ServerSocketChannel) key.channel();
                    execute(ssc);
                }
                iter.remove();
            }
        }
    }

    /**
     * 当ServerSocket接收到ACCEPT ready事件后，获取请求数据，调用相关服务接口并通过socket发送返回结果
     *
     * @param serverSocketChannel
     * @throws Exception
     */
    private static void execute(ServerSocketChannel serverSocketChannel) throws Exception {
        SocketChannel socketChannel = null;
        try {
            socketChannel = serverSocketChannel.accept();
            RpcTransactionBody rpcData = receiveData(socketChannel);
            System.out.println("---->>接收到请求 : " + rpcData);
            //
            Object target = beanCache.get(rpcData.getInterfaceName());
            if(target != null) {
                Class<?> clazz = Class.forName(rpcData.getInterfaceName());
                Method method = clazz.getMethod(rpcData.getMethodName(), rpcData.getParameterTypes());
                Object result = method.invoke(target, rpcData.getParameterValues());
                //
                sendData(socketChannel, result);
            }
        } finally {
            try {
                if (socketChannel != null)
                    socketChannel.close();
            } catch (Exception e) {
            }
        }
    }
    /**
     * 处理接受请求
     * @param socketChannel
     * @return
     */
    private static RpcTransactionBody receiveData(SocketChannel socketChannel){
        RpcTransactionBody reqObj = null;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            byte[] bytes;
            int size=0;
            while((size = socketChannel.read(buffer))>=0){
                buffer.flip();
                bytes = new byte[size];
                buffer.get(bytes);
                byteStream.write(bytes);
                buffer.clear();
            }
            bytes = byteStream.toByteArray();
            Object obj = SerializableUtil.deserialize(bytes);
            reqObj = (RpcTransactionBody) obj;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reqObj;
    }

    public static void sendData(SocketChannel socketChannel,Object respObj) throws IOException {
        byte[] bytes = SerializableUtil.serialize(respObj);
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        socketChannel.write(buffer);
    }

    public static <T>T refer(final Class<T> interfaceClass,final String host,final int port){
        if(interfaceClass ==null)
            throw new IllegalArgumentException("interfaceClass is null");
        if(!interfaceClass.isInterface())
            throw new IllegalArgumentException("The "+interfaceClass.getName()+" must be interface class!" );
        if(host == null || host.length()==0)
            throw new IllegalArgumentException("host is null!");
        if(port <= 0|| port > 65535)
            throw new IllegalArgumentException("Invalid port "+port);
        System.out.println("Get remote service "+ interfaceClass.getName() + "from server "+host+" : "+port);

        return(T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                InetSocketAddress address= new InetSocketAddress(host,port);
                SocketChannel socketChannel = SocketChannel.open();
                try {
                    socketChannel.connect(address);
                    RpcTransactionBody rpcTransactionBody = new RpcTransactionBody();
                    rpcTransactionBody.setInterfaceName(interfaceClass.getName());
                    rpcTransactionBody.setMethodName(method.getName());
                    rpcTransactionBody.setParameterTypes(method.getParameterTypes());
                    rpcTransactionBody.setParameterValues(args);
                    //写数据
                    ByteBuffer buffer = ByteBuffer.wrap(SerializableUtil.serialize(rpcTransactionBody));
                    socketChannel.write(buffer);
                    socketChannel.socket().shutdownOutput();
                    //取结果
                    Object result = receiveObject(socketChannel);
                    return result;
                }catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    socketChannel.close();
                }
                return null;
            }
        });
    }
    private static Object receiveObject(SocketChannel sc) throws Exception {
        Object resultObj = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            byte[] bytes;
            int count = 0;
            while ((count = sc.read(buffer)) >= 0) {
                buffer.flip();
                bytes = new byte[count];
                buffer.get(bytes);
                baos.write(bytes);
                buffer.clear();
            }
            bytes = baos.toByteArray();
            resultObj = SerializableUtil.deserialize(bytes);
            sc.socket().shutdownInput();
        } finally {
            try {
                baos.close();
            } catch(Exception ex) {}
        }
        return resultObj;
    }
}
