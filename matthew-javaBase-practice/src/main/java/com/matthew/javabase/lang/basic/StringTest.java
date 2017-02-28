package com.matthew.javabase.lang.basic;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-11-18 11:02
 */
public class StringTest {
    public static void main(String[] args) {
        String s ="11";
        String t = "11";
        String r ="1"+"1";
        String h = "1";
        String i ="1"+h;
        String ss = new String("11");
        String tt = new String("11");
        System.out.println(s==t);
        System.out.println(s==r);
        System.out.println(s==i);
        System.out.println(ss==tt);


        String a = "a";
        String param = new String("param" + a);
        String paramSame = param.intern();
        System.out.println(param == paramSame);
    }
}
