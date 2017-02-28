package com.matthew.javabase.juc;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-01 15:06
 */
public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) {
        ConcurrentLinkedQueue clqueue= new ConcurrentLinkedQueue<String>();
        clqueue.add("apple");
        clqueue.add("peach");
        clqueue.add("lemon");
        clqueue.add("cherry");
        clqueue.add("kiwi");
    }
}
