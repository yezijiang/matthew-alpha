package com.matthew.spring.chapter2;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-02-05 9:55
 */
public class HelloImpl2 implements HelloApi {
    public String word;
    public HelloImpl2(){
        word ="你好，世界";
    }
    public HelloImpl2(String saySomething){
        word = saySomething;
    }
    public void sayHello() {
        System.out.println(word);
    }
}
