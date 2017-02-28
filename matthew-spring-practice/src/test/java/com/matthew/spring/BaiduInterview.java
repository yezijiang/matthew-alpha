package com.matthew.spring;

import java.util.function.BooleanSupplier;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-12-15 15:49
 */
public class BaiduInterview {
    public static void main(String[] args) {
        if (((BooleanSupplier)(() -> { System.out.print("a"); return false; })).getAsBoolean()) {
            System.out.print("a");
        } else {
            System.out.print("b");
        }
    }

}
