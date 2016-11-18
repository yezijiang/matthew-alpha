package com.matthew.designPattern.singleton;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-11 11:21
 */
public class Singleton {
    private Singleton(){};

    public static Singleton getInstance(){

        return HolderClass.instance;
    }
    static class HolderClass {
        public static  Singleton instance = new Singleton();
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1==s2);
    }
}
