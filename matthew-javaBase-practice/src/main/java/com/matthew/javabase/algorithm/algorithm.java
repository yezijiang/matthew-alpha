package com.matthew.javabase.algorithm;

/**
 * 固定数组，只能0和1有多少数组并打印。
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-11-08 14:15
 */
public class algorithm {
    public static int[] A=new int[5];
    public static void main(String[] args) {
        binary(5);
    }
    public static void binary(int n){
        if(n<1){
            System.out.println(new StringBuffer().append(A[0]).append(A[1]).append(A[2]).append(A[3]).append(A[4]));
        }else{
            A[n-1]=0;
            binary(n-1);
            A[n-1]=1;
            binary(n-1);
        }
    }
    public static void nomalWay(int n) {
        for(int i =0;i< 2<<n-1;i++){
            String num =Integer.toBinaryString(i);
            for(int j = num.length(); j < n; j++) {
                num ="0"+num;
            }
            System.out.println(num.toCharArray());
        }
    }
}
