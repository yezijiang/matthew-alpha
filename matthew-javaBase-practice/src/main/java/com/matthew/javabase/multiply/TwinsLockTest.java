package com.matthew.javabase.multiply;

import org.testng.annotations.Test;

import java.util.concurrent.locks.Lock;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-08-17 21:26
 */
public class TwinsLockTest {
    @Test
    public void test(){
        final Lock lock = new TwinsLock();
        class Worker extends Thread{
            public void run() {
                while(true){
                    lock.lock();
                    try{
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }
        //启动10个线程
        for(int i=0;i<10;i++){
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        //每个1秒换行
        for(int i=0;i<100;i++){
            SleepUtils.second(1);
            System.out.println();
        }
    }
    @Test
    public void testONeThread(){
        final Lock lock = new TwinsLock();

        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    lock.lock();
                    try{
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });
        worker.start();
        System.out.println();
    }

}
