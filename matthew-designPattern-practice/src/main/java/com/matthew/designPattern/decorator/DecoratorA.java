package com.matthew.designPattern.decorator;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-18 9:33
 */
public class DecoratorA implements Decorator{
    public MyInterface myInterface;
    DecoratorA(MyInterface myObject){
        this.myInterface = myObject;
    }

    public void print() {
        myInterface.print();
        System.out.println(" world");
    }

    public static void main(String[] args) {
        int i=2;
        if((i=1)>1){
            System.out.println(111);
        }
    }
}