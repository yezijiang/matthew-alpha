package com.matthew.javabase.multiply;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-08 10:46
 */
public class ShutDown {
    public static void main(String[] args) {
        Thread countThread = new Thread(new Runner(),"CountThread");
        countThread.start();
        SleepUtils.second(1);
        countThread.interrupt();

        Runner two =new Runner();
        Thread countThreadTwo = new Thread(two,"countThreadTwo");
        countThreadTwo.start();
        SleepUtils.second(1);
        two.stop();
    }
    static class Runner implements Runnable{
        private long counter = 0;
        private volatile boolean on = true;
        public void run() {
            while(on&&!Thread.currentThread().isInterrupted()){
                counter++;
            }
            System.out.println("current counter is "+ counter);
            /**可以清理资源**/
        }
        public void stop(){
            on = false;
        }
    }
}
