package com.matthew.javabase.lang.basic;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-29 15:18
 */
public class IntegerTest {
    public static void main(String[] args) {
//        Integer i = null;
//        Integer j = null;
//        String k ="123";
//        Assign.assignInteger(i,j);
//        System.out.println(i);
//        Assign.assignString(k);
//        System.out.println(k);
//        Integer l = new Integer(6);
//        Assign.equalInteger(l);
        Integer i = new Integer(1);
        Integer k = 1;
        System.out.println(i == k);

    }
}

class Assign{
    public static void assignInteger(Integer a,Integer b){
        a=600;
        b=900;
    }
    public static void assignString(String c){
        c="1000";
    }
    public static void equalInteger(Integer a){
        System.out.println(1==a);
    }
}