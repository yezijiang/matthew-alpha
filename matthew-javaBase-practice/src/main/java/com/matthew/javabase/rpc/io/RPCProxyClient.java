package com.matthew.javabase.rpc.io;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-31 15:14
 */
public class RPCProxyClient implements  java.lang.reflect.InvocationHandler{
    private Object obj;
    public RPCProxyClient(Object obj){
        this.obj = obj;
    }

    public static Object getProxy(Object obj){
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),new RPCProxyClient(obj));
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //结果参数
        Object result = new Object();
        System.out.println("回调调用");
        //执行相关逻辑
        return result;
    }
}
