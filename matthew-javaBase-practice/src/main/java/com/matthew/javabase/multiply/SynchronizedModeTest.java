package com.matthew.javabase.multiply;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-03 16:29
 */
public class SynchronizedModeTest {
    public static TargentSynchronized targentSynchronized= new TargentSynchronized();
    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            public void run() {
                System.out.println("threadOne"+targentSynchronized.getCounter());
                targentSynchronized.counter = 12;
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadOne"+targentSynchronized.getCounter());
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            public void run() {
                System.out.println("threadTwo"+targentSynchronized.getCounter());
            }
        });
    }
}
