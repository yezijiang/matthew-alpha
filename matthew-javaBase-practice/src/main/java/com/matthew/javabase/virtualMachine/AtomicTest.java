package com.matthew.javabase.virtualMachine;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-02 14:23
 */
public class AtomicTest {
    public static AtomicInteger race = new AtomicInteger(0);
    public static final int THREAD_SIZE =20;
    public static void increase(){
        race.incrementAndGet();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_SIZE];
        for(int i=0;i<THREAD_SIZE;i++){
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for(int j=0;j<1000000;j++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while(Thread.activeCount()>1){
            System.out.println(Thread.activeCount());
        }
    }
}
