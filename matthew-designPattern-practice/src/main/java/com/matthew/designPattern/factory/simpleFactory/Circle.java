package com.matthew.designPattern.factory.simpleFactory;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-26 14:28
 */
public class Circle implements Shape{
    public void draw() {
        System.out.println("园被画出");
    }

    public void erase() {
        System.out.println("circle is erased");
    }
}
