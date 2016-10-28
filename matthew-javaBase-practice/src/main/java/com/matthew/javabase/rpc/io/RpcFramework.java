package com.matthew.javabase.rpc.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

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
        ServerSocket server = new ServerSocket(port);
        for(;;){
            final Socket socket = server.accept();
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
