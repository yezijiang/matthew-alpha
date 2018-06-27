package com.matthew.javabase.juc;

import com.matthew.javabase.lang.*;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-08-22 18:20
 */
public class AtomicStampedReferenceTest {
    public static void main(String[] args) {
        People xiaoma = new People(55,"xiaoMa");
        AtomicStampedReference<People> atomicUser = new AtomicStampedReference<People>(xiaoma,22);

        System.out.println( atomicUser.getReference().getNickName());
        System.out.println( atomicUser.getStamp());
        People xiaoWang = new People(55,"xiaoWang");
        atomicUser.compareAndSet(xiaoma,xiaoWang,22,23);
        System.out.println( atomicUser.getReference().getNickName());
        System.out.println( atomicUser.getStamp());
    }
}
