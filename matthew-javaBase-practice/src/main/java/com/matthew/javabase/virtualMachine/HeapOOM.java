package com.matthew.javabase.virtualMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-07-27 10:09
 */
public  class HeapOOM {
    static class OOMObject{}

    /**
     * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list= new ArrayList<OOMObject>();
        while (0<1){
            list.add(new OOMObject());
        }


//        /**1**/
//        char x = 'x';System.out.println(true?120:x);
//        /**2**/
//        for(int i=0;i<10;i++)
//            Integer k=new Integer(i);
//
//        System.out.println("hello world");
//
//
//
//        int[] arr = new int[]{1,2,3};
//        List list =  Arrays.asList(arr);
//        System.out.println(Arrays.asList(arr).contains(1));
    }
}
