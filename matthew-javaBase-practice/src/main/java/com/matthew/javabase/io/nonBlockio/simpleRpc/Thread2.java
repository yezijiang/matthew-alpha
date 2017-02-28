package com.matthew.javabase.io.nonBlockio.simpleRpc;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-07-22 9:48
 */
public class Thread2 implements Runnable{
    private RpcServer rpcServer;
    Thread2(RpcServer rpcServer){
        this.rpcServer = rpcServer;
    }
    public void run() {
        rpcServer.people = new People();
        System.out.println("two:"+rpcServer.people);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
