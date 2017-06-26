package com.matthew.spring.chapter3;

import com.matthew.spring.chapter2.HelloApi;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-02-09 10:23
 */
public class HelloApiDecorator implements HelloApi {
    private HelloApi helloApi;

    public HelloApiDecorator(HelloApi helloApi) {
        this.helloApi = helloApi;
    }
    public HelloApiDecorator() {}
    public void setHelloApi(HelloApi helloApi) {
        this.helloApi = helloApi;
    }

    public void sayHello() {
        System.out.println("装饰一下。");
        helloApi.sayHello();
        System.out.println("装饰结束。");
    }
}
