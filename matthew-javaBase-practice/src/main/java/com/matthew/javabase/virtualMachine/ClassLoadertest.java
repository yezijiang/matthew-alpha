package com.matthew.javabase.virtualMachine;

import java.io.IOException;
import java.io.InputStream;

/**
 * 验证不同的classLoader加载相同的类 instanceOf()会不同。
 * 即classLoader和类本身共同决定类在JVM中的唯一性。
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-08-16 14:07
 */
public class ClassLoadertest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                    System.out.println(fileName);
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null){
                        return super.loadClass(name);
                    }
                    byte[]  b =new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return  super.loadClass(name);
            }
        };
        Object obj= myLoader.loadClass("com.matthew.javabase.virtualMachine.ClassLoadertest").newInstance();
        System.out.println(obj);
        System.out.println(obj instanceof com.matthew.javabase.virtualMachine.ClassLoadertest);

    }



}
