package com.matthew.javabase.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-08 14:22
 */
public class CyclicBarrierTest {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2,new A());

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("线程一开始");
                try {
                    Thread.currentThread().sleep(1222);
                    cyclicBarrier.await();
                    //到达屏障之后的共同处理
                    System.out.println("共同处理线程一");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("主线程开始");
        cyclicBarrier.await();
        System.out.println("共同处理主线程");
    }
    static class A implements Runnable{
        public void run() {
            System.out.println("事先执行的线程三 befor await");
        }
    }
}
