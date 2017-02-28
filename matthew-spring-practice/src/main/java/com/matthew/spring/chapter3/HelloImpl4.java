package com.matthew.spring.chapter3;

import com.matthew.spring.chapter2.HelloApi;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-02-08 10:41
 */
public class HelloImpl4 implements HelloApi {
    private String message;

    private int index;



    @Override
    public void sayHello() {
        System.out.println("i'm the"+index+"'s employee,"+message);
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
