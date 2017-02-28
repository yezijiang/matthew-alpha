package com.matthew.javabase.juc;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-07 17:14
 */
public class AtomicReferenceTest {
    public static AtomicReference<People> peopleAtomicReference = new AtomicReference<People>();


    public static void main(String[] args) {
        People xiaoGao = new People(55,"xiaoGao");
        peopleAtomicReference.set(xiaoGao);
        System.out.println(peopleAtomicReference.get().getNickName());
        System.out.println(peopleAtomicReference.get().getWeight());
        xiaoGao.setNickName("xixi");
        System.out.println(peopleAtomicReference.get().getNickName());
        System.out.println(peopleAtomicReference.get().getWeight());
        People xiaoMa = new People(60,"xiaoMa");
        peopleAtomicReference.compareAndSet(xiaoGao,xiaoMa);
        System.out.println(peopleAtomicReference.get().getNickName());
    }
}
