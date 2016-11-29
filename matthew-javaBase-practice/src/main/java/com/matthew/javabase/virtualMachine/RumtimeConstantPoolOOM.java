package com.matthew.javabase.virtualMachine;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-07-28 11:51
 */
public class RumtimeConstantPoolOOM {
    public static void main(String[] args) {
        String str1 = new StringBuilder("ja1").append("va").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
