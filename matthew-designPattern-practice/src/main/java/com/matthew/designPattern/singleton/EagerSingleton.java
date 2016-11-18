package com.matthew.designPattern.singleton;

/**
 * 饿汉式
 * 饿汉式中简单的多例模式是多个对象，
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-11 10:29
 */
public class EagerSingleton {
    private static EagerSingleton eagerSingleton = new EagerSingleton();
    private EagerSingleton(){};
    public static EagerSingleton getInstance(){
        return eagerSingleton;
    }

}
