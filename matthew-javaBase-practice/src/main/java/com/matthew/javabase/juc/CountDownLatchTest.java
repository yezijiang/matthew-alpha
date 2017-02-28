package com.matthew.javabase.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-08 10:58
 */
public class CountDownLatchTest{
    private static CountDownLatch c = new CountDownLatch(3);
    static CyclicBarrier  cyclicBarrier= new CyclicBarrier(2);
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.currentThread().sleep(1000);
                    System.out.println("任务执行一");
                    c.countDown();
                    System.out.println("任务执行二");
                    c.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        c.await();
        System.out.println("重点任务");

    }
}
