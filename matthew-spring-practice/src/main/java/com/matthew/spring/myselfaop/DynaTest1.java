package com.matthew.spring.myselfaop;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-06 16:58
 */
public class DynaTest1 {
    public static void main(String[] args) {
        Hello hello = (Hello) new ProxyHandler().bind(new LoggerImpl(),new HelloImpl());
        hello.sayHello();

    }
}
