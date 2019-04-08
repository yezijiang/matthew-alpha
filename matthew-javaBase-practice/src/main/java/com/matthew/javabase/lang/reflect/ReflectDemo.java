package com.matthew.javabase.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-07-31 13:22
 */
public class ReflectDemo {
    public static void getConstructor(String fullClassName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1通过类加载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz= loader.loadClass(fullClassName);
        //
        Constructor cons = clazz.getConstructor(String.class,String.class,int.class);
        Car myNewCar = (Car)cons.newInstance("benz","white",220);

        //
        Method introduce = clazz.getDeclaredMethod("introduce");

        introduce.invoke(myNewCar);
        //
        Field[] allFields = clazz.getDeclaredFields();
        for(Field field:allFields){
            field.setAccessible(true);
            System.out.println(field.get(myNewCar).toString());
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String fullCalssName= "com.matthew.javabase.lang.reflect.Car";
        ReflectDemo.getConstructor(fullCalssName);
    }
}
