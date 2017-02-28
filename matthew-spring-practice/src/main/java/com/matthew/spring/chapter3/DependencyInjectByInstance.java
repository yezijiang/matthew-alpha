package com.matthew.spring.chapter3;

import com.matthew.spring.chapter2.HelloApi;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-02-08 10:22
 */
public class DependencyInjectByInstance {
    public HelloApi getHelloApiInstance(String message,int index){
        return new HelloImpl3(message,index);
    }
}
