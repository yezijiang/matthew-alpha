package com.matthew.designPattern.decorator;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-20 11:26
 */
public class ScrollBarDecorator extends ComponentDecorator {
    public ScrollBarDecorator(Component component) {
        super(component);
    }
    public void display(){
        this.setScrollbar();
        super.display();
    }
    public void setScrollbar(){
        System.out.println("为构件增加滚动条");
    }
}
