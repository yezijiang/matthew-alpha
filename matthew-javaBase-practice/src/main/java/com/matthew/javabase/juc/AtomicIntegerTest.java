package com.matthew.javabase.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-07 16:47
 */
public class AtomicIntegerTest {
    public static  AtomicInteger counter = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println( counter.get());
        counter.set(11);
        System.out.println( counter.get());
        System.out.println( counter.addAndGet(1));
        System.out.println( counter.getAndSet(12));
        int value[] = new int[]{0,2};
        AtomicIntegerArray counterArray = new AtomicIntegerArray(value);
        System.out.println(counterArray.getAndAdd(0,12));
        System.out.println(counterArray.get(0));
        counterArray.compareAndSet(0,0,13);
        System.out.println(counterArray.get(0));
        System.out.println(value[0]);
    }
}
