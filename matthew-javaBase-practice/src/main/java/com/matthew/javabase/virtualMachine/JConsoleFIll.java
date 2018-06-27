package com.matthew.javabase.virtualMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-07-18 10:47
 */
public class JConsoleFIll {
    static class OOMObject{
        public byte[] placeholder = new byte[64*1024];
    }
    public static void fillHeap(int num) throws InterruptedException{
        List<OOMObject> list = new ArrayList<OOMObject>();
        for(int i =0;i<num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
