package com.matthew.javabase.io.nonBlockio.simpleRpc;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-07-22 9:39
 */
public class Thread1 implements Runnable {
    private RpcServer rpcServer;
    Thread1(RpcServer rpcServer){
        this.rpcServer = rpcServer;
    }
    public void run() {
        rpcServer.people = new People();
        System.out.println("one:"+rpcServer.people);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one:"+rpcServer.people);
    }
}
