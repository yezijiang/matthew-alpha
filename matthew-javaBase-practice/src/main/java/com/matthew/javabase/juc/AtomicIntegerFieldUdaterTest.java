package com.matthew.javabase.juc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-08 10:35
 */
public class AtomicIntegerFieldUdaterTest {
    public static AtomicIntegerFieldUpdater<People> peopleAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(People.class,"weight");

    public static void main(String[] args) {
        People xiaoma = new People(55,"xiaoMa");
        System.out.println(peopleAtomicIntegerFieldUpdater.getAndIncrement(xiaoma));
        //xiaoma are getting fat
        System.out.println(peopleAtomicIntegerFieldUpdater.get(xiaoma));
    }
}
