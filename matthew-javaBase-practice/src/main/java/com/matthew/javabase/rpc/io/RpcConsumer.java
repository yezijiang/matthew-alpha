package com.matthew.javabase.rpc.io;

import javax.xml.ws.Service;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-28 16:41
 */
public class RpcConsumer {
    public static void main(String[] args) throws InterruptedException {
        HelloService service = RpcFramework.refer(HelloService.class,"127.0.0.1",1234);
        String hello = service.hello("world");
        System.out.println(hello);
    }
}

