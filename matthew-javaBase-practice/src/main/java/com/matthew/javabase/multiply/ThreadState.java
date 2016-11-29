package com.matthew.javabase.multiply;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-05 11:37
 */
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"timeWaitingThread").start();
        new Thread(new Waiting(),"waitingThread").start();

        new Thread(new Blocked(),"BlockedThread").start();
        new Thread(new Blocked(),"isBlockedThread").start();
    }
    //该线程不停地进行睡眠
    static class TimeWaiting implements Runnable{
        public void run() {
            while(true){
                SleepUtils.second(100);
            }
        }
    }
   //该线程在某实例数据上等待
    static class Waiting implements Runnable{
       public void run() {
           while(true){
               synchronized(Waiting.class){
                   try {
                       Waiting.class.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       }
   }
    static class Blocked implements Runnable{
        public void run() {
            synchronized(Blocked.class){
                while(true){
                    SleepUtils.second(10);
                }
            }
        }
    }

}
