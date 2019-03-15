package com.matthew.javabase.lang.basic;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-01 16:59
 * 验证java类的初始化顺序
 */
public class Father {
    private static String name = "lily";
    static{
        System.out.println(name);
    }
    {
        System.out.println(this.sex);
    }
    private String sex = "male";
    {
        System.out.println(this.sex);
    }

    public Father() {
        System.out.println("构造函数初始化");

    }

    public static void main(String[] args) {
        Father father = new Father();
    }
}
