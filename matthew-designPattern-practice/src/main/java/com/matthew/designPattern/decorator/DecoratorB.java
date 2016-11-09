package com.matthew.designPattern.decorator;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-18 9:41
 */
public class DecoratorB implements Decorator{
    public MyInterface myInterface;
    DecoratorB(MyInterface myObject){
        this.myInterface = myObject;
    }
    public void print() {
        System.out.print("say ");
        myInterface.print();
    }
    public static void main(String[] args){
        MyInterface a =new DecoratorB(new DecoratorA(new MyClass()));
        a.print();
    }
}
