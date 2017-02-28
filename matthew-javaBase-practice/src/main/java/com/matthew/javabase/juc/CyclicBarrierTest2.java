package com.matthew.javabase.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-08 15:05
 */
public class CyclicBarrierTest2 {
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args){
        Thread c = new Thread(new Runnable() {
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                } catch (BrokenBarrierException e) {
                }
            }
        });
        c.start();
        c.interrupt();
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            System.out.println(cyclicBarrier.isBroken());
        }

    }
}
