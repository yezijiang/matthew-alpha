package com.matthew.javabase.juc;

import com.matthew.javabase.multiply.ThreadPool;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2018-06-04 14:01
 */
public class TestRunnable implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<10000;i++){
            System.out.println(i);
        }
    }
}
class TestDemo2{
    public static void main(String[] args) {
        Runnable tr  = new TestRunnable();
        Thread thread = new Thread(tr);
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
