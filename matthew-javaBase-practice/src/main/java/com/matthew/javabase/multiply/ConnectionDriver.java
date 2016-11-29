package com.matthew.javabase.multiply;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-09 15:20
 */
public class ConnectionDriver {
    static class ConnectionHandler implements InvocationHandler{

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(method.getName().equals("commit")){
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }

    public static final Connection createConnection(){
        return (Connection)Proxy.newProxyInstance(ConnectionHandler.class.getClassLoader(),new Class<?>[]{Connection.class},new ConnectionHandler());
    }
}
