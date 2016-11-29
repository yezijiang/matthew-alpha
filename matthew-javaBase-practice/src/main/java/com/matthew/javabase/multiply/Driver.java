package com.matthew.javabase.multiply;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLa
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-10 10:28
 */
public class Driver {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(5);
        Worker worker = new Worker(startSignal,doneSignal);
        for(int i=0;i<5;i++){
            new Thread(worker,"extraThread"+i).start();
        }
        System.out.println("主流程处理");
        SleepUtils.second(1);
        startSignal.countDown();
        System.out.println("其他线程开始");
        doneSignal.await();
        System.out.println("所有线程完成");
    }


}

class Worker implements Runnable{
   private CountDownLatch startSignal;
   private CountDownLatch doneSignal;
   public Worker(CountDownLatch startSignal,CountDownLatch doneSignal){
       this.startSignal = startSignal;
       this.doneSignal = doneSignal;
   }
   public void run() {
       try {
           System.out.println(Thread.currentThread().getName()+" is block");
           startSignal.await();
           System.out.println(Thread.currentThread().getName()+" is do some process!");
           doneSignal.countDown();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

   }
}