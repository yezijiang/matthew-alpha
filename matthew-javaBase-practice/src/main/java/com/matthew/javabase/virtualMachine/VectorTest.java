package com.matthew.javabase.virtualMachine;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-02 10:50
 */
public class VectorTest {
    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {
        while(true){
            for(int i=0;i<10;i++){
                vector.add(i);
            }
            Thread removeThread = new Thread(new Runnable() {
                public void run() {
                    for(int i = 0;i<vector.size();i++){
                        vector.remove(i);
                    }
                }
            });
            Thread printThread = new Thread(new Runnable() {
                public void run() {
                    for(int i = 0;i<vector.size();i++){
                        System.out.println(vector.get(i));
                    }
                }
            });
            removeThread.start();
            printThread.start();
            while (Thread.activeCount()>5);
        }

    }

}
