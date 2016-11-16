package com.matthew.javabase.lang.keyword;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-11-15 17:13
 */
public class SyncTest {
    public SyncTest syncVar;
    public static SyncTest syncStaticVar;
    public static synchronized void testStaticSync() throws InterruptedException {
        System.out.println("test sync static method start!");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("test sync static method end!");

    }
    public synchronized void testNonStaticSync() throws InterruptedException {
        System.out.println("test sync method start!");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("test sync method end.");
    }
    public void testSyncThis() throws InterruptedException {
        synchronized(this){
            System.out.println("test sync this start!");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("test sync this end");
        }
    }
    public void testSyncVar() throws InterruptedException {
        synchronized(syncVar){
            System.out.println("test sync var start");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("test sync var end");
        }
    }
    public void testStaticVar() throws InterruptedException {
        synchronized(syncStaticVar){
            System.out.println("test sync static var start");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("test sync static var end");
        }
    }

    public static void main(String[] args) {
        final SyncTest testSync = new SyncTest();
        testSync.syncVar = new SyncTest();
        testSync.syncStaticVar = new SyncTest();
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    testSync.testSyncThis();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    testSync.testSyncVar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadOne.start();
        threadTwo.start();
    }

}
