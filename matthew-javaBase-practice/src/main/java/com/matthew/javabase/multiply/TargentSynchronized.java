package com.matthew.javabase.multiply;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-03 16:42
 */
public class TargentSynchronized {
    public int counter = 0;

    public synchronized int getCounter() {
        return counter;
    }

    public synchronized void setCounter(int counter) {
        this.counter = counter;
    }
}
