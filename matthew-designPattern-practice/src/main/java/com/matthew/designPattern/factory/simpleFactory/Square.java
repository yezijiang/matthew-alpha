package com.matthew.designPattern.factory.simpleFactory;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-26 14:28
 */
public class Square implements Shape {
    public void draw() {
        System.out.println("正方形被画出");
    }

    public void erase() {
        System.out.println("square is erased");
    }
}
