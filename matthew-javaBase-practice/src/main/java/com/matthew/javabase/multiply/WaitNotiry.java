package com.matthew.javabase.multiply;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-08 14:27
 */
public class WaitNotiry {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread waitThread = new Thread(new Wait(),"waitThread");
        waitThread.start();
        SleepUtils.second(1);
        Thread notifyThread = new Thread(new Notify(),"notifyThread");
        notifyThread.start();
    }
    static class Wait implements Runnable{
        public void run() {
            synchronized (lock){
                 while(flag){
                     System.out.println(Thread.currentThread()+"flag is true. wait @"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                     try {
                         lock.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                }
                //条件满足时，完成工作
                System.out.println(Thread.currentThread()+"flag is false. runing @"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
    static class Notify implements Runnable{
        public void run() {
            //加锁，拥有lock的monitor
            /**获取lock的锁，然后进行通知，通知时不会释放lock的锁，
             * 直到当前线程释放了lock后，waitThread才能从wait方法中返回*/
            synchronized (lock){
                System.out.println(Thread.currentThread()+"hold lock.notify @"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag =false;
                SleepUtils.second(5);
            }
            //再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread()+"hold lock again @"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }
        }
    }
}
