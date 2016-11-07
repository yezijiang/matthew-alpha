package com.matthew.javabase.rpc.nio;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-28 16:40
 */
public class RpcProvider{
    public static void main(String[] args) {
        HelloService service = new HelloServiceImpl();
        try {
            RpcFramework.export(service,8099);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
