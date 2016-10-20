package com.matthew.designPattern.decorator;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-20 11:28
 */
public class BlackBorderDecorator extends ComponentDecorator {

    public BlackBorderDecorator(Component component) {
        super(component);
    }

    public void setBlackBorder(){
        System.out.println("为构件增加黑色边框！");
    }

    @Override
    public void display() {
        this.setBlackBorder();
        super.display();
    }
}
