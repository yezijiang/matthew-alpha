package com.matthew.javabase.rpc.io;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-28 16:40
 */
public class RpcProvider{
    public static void main(String[] args) throws IOException {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service,1234);
    }
}
