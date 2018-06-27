package com.matthew.javabase.multiply;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-08-21 14:31
 */
public class BoundedQueue<T> {
    private Lock lock = new ReentrantLock();
    private Condition notEnpty = lock.newCondition();
    private BoundedQueue() {
    }

    public void add() throws InterruptedException {
        notEnpty.await();

    }
    public static void main(String[] args) throws InterruptedException {
        BoundedQueue t = new BoundedQueue();
        t.add();
    }
}
