package com.matthew.javabase.rpc.nio;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-28 16:39
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello"+ name;
    }
}
