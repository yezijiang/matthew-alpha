package com.matthew.javabase.lang.genericity;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-07-25 11:15
 */
public class TwoTuple<A,B> {
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }
}
