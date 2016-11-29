package com.matthew.javabase.virtualMachine;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-07-29 10:56
 */
public class VolatileTest {
    public static volatile int race = 0;
    public static void increase(){
        race++;
    }
    public static final int THREAD_SIZE=20;
    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_SIZE];
        for (int i = 0; i < THREAD_SIZE; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while(Thread.activeCount()<1){
            Thread.yield();
        }
        System.out.println(race);
    }
}
