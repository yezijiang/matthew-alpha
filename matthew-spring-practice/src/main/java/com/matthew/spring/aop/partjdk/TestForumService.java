package com.matthew.spring.aop.partjdk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-05-10 11:20
 */
public class TestForumService {
    public static void main(String[] args) {
        ForumService target = new ForumServiceImpl();//希望被代理的业务类
        PerformanceHandler handler = new PerformanceHandler(target);

        ForumService proxy = (ForumService)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        proxy.removeForum(10);
        proxy.removeTopic(1024);
        System.out.println(proxy.getClass().getName());
        Class clz = proxy.getClass();
        printClassDefinition(clz);

    }

    public static String getModifier(int modifier){
        String result = "";
        switch(modifier){
            case Modifier.PRIVATE:
                result = "private";
            case Modifier.PUBLIC:
                result = "public";
            case Modifier.PROTECTED:
                result = "protected";
            case Modifier.ABSTRACT :
                result = "abstract";
            case Modifier.FINAL :
                result = "final";
            case Modifier.NATIVE :
                result = "native";
            case Modifier.STATIC :
                result = "static";
            case Modifier.SYNCHRONIZED :
                result = "synchronized";
            case Modifier.STRICT  :
                result = "strict";
            case Modifier.TRANSIENT :
                result = "transient";
            case Modifier.VOLATILE :
                result = "volatile";
            case Modifier.INTERFACE :
                result = "interface";
        }
        return result;
    }
    public static void printClassDefinition(Class clz){
        //输出class的类型，继承和实现
        String clzModifier = getModifier(clz.getModifiers());
        if(clzModifier!=null && !clzModifier.equals("")){
            clzModifier = clzModifier+"";
        }

        String superClz = clz.getSuperclass().getName();
        if(superClz!=null && !superClz.equals("")){
            superClz = "extends " + superClz;
        }

        Class[] interfaces = clz.getInterfaces();
        String inters ="";
        for(int i=0;i<interfaces.length;i++){
            if(i==0){
                inters += "implements ";
            }
            inters += interfaces[i].getName();
        }
        System.out.println(clzModifier +clz.getName()+" " + superClz +" " + inters );
        System.out.println("{");
        //输出该class的字段
        Field[] fields = clz.getDeclaredFields();
        for(int i=0; i<fields.length; i++){
            String modifier = getModifier(fields[i].getModifiers());
            if(modifier!=null && !modifier.equals("")){
                modifier = modifier + " ";
            }
            String fieldName = fields[i].getName();
            String fieldType = fields[i].getType().getName();
            System.out.println("    "+modifier + fieldType + " "+ fieldName + ";");
        }

        System.out.println();
        //输出该class方法
        Method[] methods = clz.getDeclaredMethods();
        for(int i=0;i<methods.length;i++){
            Method method = methods[i];
            String modifier = getModifier(method.getModifiers());
            if(modifier != null && !modifier.equals("")){
                modifier = modifier +"";
            }
            String methodName = method.getName();
            Class returnClz = method.getReturnType();
            String returnType = returnClz.getName();

            Class[] clzs = method.getParameterTypes();
            String paraList="(";
            for(int j=0;j<clzs.length;j++){
                paraList += clzs[j].getName();
                if(j!=clzs.length-1){
                    paraList+=",";
                }
            }
            paraList += ")";

            clzs = method.getExceptionTypes();
            String exceptions="";
            for(int j =0;j<clzs.length;j++){
                if(j==0){
                    exceptions +="throws";
                }
                exceptions += clzs[j].getName();
                if(j != clzs.length-1){
                    exceptions += ",";
                }
            }
            exceptions +=";";
            String methodPrototype = modifier +returnType+" "+methodName+paraList+exceptions;

            System.out.println("    "+methodPrototype );

        }

        System.out.println("}");
    }
}
