package com.matthew.spring.chapter3;

import com.matthew.spring.chapter2.HelloApi;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-02-07 14:56
 */
public class HelloImpl3 implements HelloApi {
    private String message;
    private int index;
    public HelloImpl3(String message,int index){
        this.message = message;
        this.index= index;
    }
    @Override
    public void sayHello() {
        System.out.println("i'm the "+index+"'s employee,"+message);
    }
}
