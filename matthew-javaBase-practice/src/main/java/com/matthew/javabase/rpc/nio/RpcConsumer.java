package com.matthew.javabase.rpc.nio;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-28 16:41
 */
public class RpcConsumer {
    public static void main(String[] args) throws InterruptedException {
        HelloService service = RpcFramework.refer(HelloService.class,"127.0.0.1",1234);
        for(int i=0;i<Integer.MAX_VALUE;i++){
            String hello = service.hello("world"+i);
            System.out.println(hello);
            Thread.sleep(1000);
        }
    }
}

