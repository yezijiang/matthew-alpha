package com.matthew.spring.myselfaop;

import javax.naming.event.ObjectChangeListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-06 16:46
 */
public class ProxyHandler implements InvocationHandler {
    //调用对象
    private Object proxy;
    //目标对象
    private Object target;
    public Object bind(Object proxy,Object target){
        this.proxy =proxy;
        this.target = target;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),this.target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class clazz = this.proxy.getClass();
        //反射得到操作者的start方法
        Method start = clazz.getDeclaredMethod("start",new Class[]{Method.class});
        //反射执行start方法
        start.invoke(this.proxy,method);

        //执行要处理对象的原本方法
        method.invoke(this.target,args);

        Method end = clazz.getDeclaredMethod("end",new Class[]{Method.class});
        end.invoke(this.proxy,method);

        return null;
    }
}
