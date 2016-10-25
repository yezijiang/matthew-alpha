package com.matthew.designPattern.factory.simpleFactory;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-26 14:28
 */
public class Triangle implements Shape{
    public void draw() {
        System.out.println("三角形被画出");
    }

    public void erase() {
        System.out.println("triangle is erased");
    }
}
