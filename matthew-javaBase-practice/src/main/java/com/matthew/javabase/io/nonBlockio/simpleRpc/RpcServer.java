package com.matthew.javabase.io.nonBlockio.simpleRpc;


/**
 *
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-07-21 16:37
 */
public class RpcServer {
    public static People people;
    public static void main(String[] args) {
        RpcServer rpcServer =new RpcServer();
        new Thread(new Thread1(rpcServer)).start();
        new Thread(new Thread2(rpcServer)).start();
    }
    private volatile int a =0;
}
