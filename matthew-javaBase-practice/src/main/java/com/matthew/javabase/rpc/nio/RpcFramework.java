package com.matthew.javabase.rpc.nio;

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
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-28 16:43
 */
public class RpcFramework {
    public static void export(final Object service,int port) throws IOException {
        if(service == null)
            throw new IllegalArgumentException("service instance is null");
        if(port<=0||port>65535)
            throw new IllegalArgumentException("Invalid port "+port);
        System.out.println("Export service "+service.getClass().getName()+" on port "+port);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //通过静态工厂创建一个选择器，
        Selector selector = Selector.open();
        //通过静态广场创建服务端的channel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //设置为非阻塞方式
        ssc.configureBlocking(false);
        //绑定一个端口
        ssc.bind(new InetSocketAddress(port));
        //将这个通信信道注册到选择器上。
        ssc.register(selector,SelectionKey.OP_ACCEPT);
        while(true){
            Set selectedKeys = selector.selectedKeys();
            Iterator it = selectedKeys.iterator();
            while (it.hasNext()){
                SelectionKey selectionKey = (SelectionKey) it.next();
                if((selectionKey.readyOps() & SelectionKey.OP_ACCEPT)==SelectionKey.OP_ACCEPT){
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel sc = serverSocketChannel.accept();//接受服务端的请求
                    sc.configureBlocking(false);
                    sc.register(selector,SelectionKey.OP_READ);
                    it.remove();
                }else if((selectionKey.readyOps() & SelectionKey.OP_READ)==SelectionKey.OP_READ){
                    SocketChannel sc = (SocketChannel) selectionKey.channel();
                    while (true){
                        buffer.clear();
                        int n = sc.read(buffer);
                        if(n<=0) break;
                        buffer.flip();


                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
                                    try {
                                        String methodName = objectInput.readUTF();
                                        Class<?>[] parameterTypes = (Class<?>[])objectInput.readObject();
                                        Object[] arguments = (Object[])objectInput.readObject();
                                        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                                        Method method = null;
                                        try {
                                            method = service.getClass().getMethod(methodName, parameterTypes);
                                            Object result = method.invoke(service, arguments);
                                            output.writeObject(result);
                                        } catch (NoSuchMethodException e) {
                                            e.printStackTrace();
                                        } catch (InvocationTargetException e) {
                                            e.printStackTrace();
                                        } catch (IllegalAccessException e) {
                                            e.printStackTrace();
                                        }
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();


                    }
                }
            }




        }
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
                Socket socket = new Socket(host,port);
                try {
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    try {
                        outputStream.writeUTF(method.getName());
                        outputStream.writeObject(method.getParameterTypes());
                        outputStream.writeObject(args);
                        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                        try {
                            Object result = input.readObject();
                            if (result instanceof Throwable) {
                                throw (Throwable) result;
                            }
                            return result;
                        } finally {
                            input.close();
                        }
                    } finally {
                        outputStream.close();
                    }
                }finally {
                    socket.close();
                }
            }
        });
    }
}
