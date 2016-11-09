package com.matthew.designPattern.decorator;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-20 11:29
 */
public class Client {
    public static void main(String[] args) {
        //表现一个有黑色边框的输入框
        Component component = new TextBox();
        BlackBorderDecorator componentDecorator = new BlackBorderDecorator(component);
        ScrollBarDecorator component1 = new ScrollBarDecorator(componentDecorator);
        component1.display();
    }
}
