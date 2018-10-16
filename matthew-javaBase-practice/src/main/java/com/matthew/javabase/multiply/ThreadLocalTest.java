package com.matthew.javabase.multiply;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-05 16:51
 */
public class ThreadLocalTest {
    public static final ThreadLocal<Long> threadLocal = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue () {
            System.out.println("initailVuale");
            return System.currentTimeMillis();
        }
    };
    public static void main(String[] args) {
     ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        System.out.println(threadLocalTest.threadLocal.get());
        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println(Integer.SIZE - 3);
        System.out.println( Integer.toBinaryString((1 << COUNT_BITS) - 1));

    }
}
