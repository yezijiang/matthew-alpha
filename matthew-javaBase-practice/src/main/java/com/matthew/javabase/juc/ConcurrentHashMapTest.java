package com.matthew.javabase.juc;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-30 15:14
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        int sshift = 0;
        int ssize = 1;
        while (ssize < 16) {
            ++sshift;
            ssize <<= 1;
        }
        System.out.println(ssize);
        System.out.println(sshift);
        System.out.println(sshift >>> 1);
    }
}
