package com.matthew.javabase.lang.keyword;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-11-15 16:54
 */
public class SynchronizeTest {
    public  void printA() throws InterruptedException {
        synchronized(this){
        TimeUnit.SECONDS.sleep(2);
        System.out.println("aaaaaaaaaaaaa");
        }
    }
    public  void printB() throws InterruptedException {
        synchronized(this) {
            System.out.println("bbbbbbb");
        }
    }

    public static void main(String[] args) {
        SynchronizeTest synchronizeTest = new SynchronizeTest();
        new Thread(new Runclass(synchronizeTest)).start();
        new Thread(new Runclass2(synchronizeTest)).start();
    }

}
class Runclass implements Runnable{
    SynchronizeTest synchronizeTest;
    public Runclass(SynchronizeTest synchronizeTest){
        this.synchronizeTest= synchronizeTest;
    }
    @Override
    public void run() {
        try {
            synchronizeTest.printA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Runclass2 implements Runnable{
    SynchronizeTest synchronizeTest;
    Runclass2(SynchronizeTest synchronizeTest){
        this.synchronizeTest= synchronizeTest;
    }
    @Override
    public void run() {
        try {
            synchronizeTest.printB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
