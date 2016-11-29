package com.matthew.javabase.multiply;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-08 10:18
 */
public class Interrupted {
    public static void main(String[] args) {
        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(),"BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        /**休息5秒，充分确保两个线程启动**/
        SleepUtils.second(5);
        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("sleepThread isinterrupted is "+sleepThread.isInterrupted());
        System.out.println("busyThread isinterrupted is" + busyThread.isInterrupted());



    }
    /**一直休眠**/
    static class SleepRunner implements Runnable{
        public void run() {
            while(true){
                SleepUtils.second(10);
            }
        }
    }
    /** 一直不停地工作 **/
    static class BusyRunner implements Runnable{
        public void run() {
            while(true){
            }
        }
    }
}
