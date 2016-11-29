package com.matthew.javabase.multiply;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-05 11:50
 */
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
