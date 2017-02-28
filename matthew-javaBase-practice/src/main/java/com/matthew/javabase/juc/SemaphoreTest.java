package com.matthew.javabase.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-08 15:30
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore semaphore =new Semaphore(1);

    public static void main(String[] args) {
        for(int i=0;i<THREAD_COUNT;i++){
            threadPool.execute(new Thread(new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("save data");
                    System.out.println(semaphore.availablePermits());
                    System.out.println(semaphore.getQueueLength());
                    semaphore.release();
                }
            }));
        }
    }
}
