package com.matthew.javabase.lang;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-07-26 17:06
 */
public class UnatomicLong implements Runnable {
    private static long test = 0;

    private final long val;

    public UnatomicLong(long val) {
        this.val = val;
    }

    public void run() {
        while (!Thread.interrupted()) {
            test = val;
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new UnatomicLong(-1));
        Thread t2 = new Thread(new UnatomicLong(0));

        System.out.println(Long.toBinaryString(-1));
        System.out.println(pad(Long.toBinaryString(0), 64));

        t1.start();
        t2.start();

        long val;
        while ((val = test) == -1 || val == 0) {
        }

        System.out.println(pad(Long.toBinaryString(val), 64));
        System.out.println(val);

        t1.interrupt();
        t2.interrupt();
    }

    // prepend 0s to the string to make it the target length
    private static String pad(String s, int targetLength) {
        int n = targetLength - s.length();
        for (int x = 0; x < n; x++) {
            s = "0" + s;
        }
        return s;
    }
}