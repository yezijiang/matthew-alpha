package com.matthew.javabase.multiply;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-04 10:24
 */
public class ConcurrentTest {
    public static final int count = 10000;

    public static void concurrent() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        Thread increamThread = new Thread(new Runnable() {
            public void run() {
                int a =0;
                for(long i=0;i<count;i++){
                    a +=5;
                }
            }
        });
        increamThread.start();
        int b =0;
        for(long i=0;i<count;i++){
            b += 5;
        }
        increamThread.join();
        long endTime = System.currentTimeMillis();
        System.out.println("concurren="+(endTime-beginTime));
    }
    public static void serial(){
        long beginTime = System.currentTimeMillis();
        int a =0;
        for(long i=0;i<count;i++){
            a +=5;
        }
        int b =0;
        for(long i=0;i<count;i++){
            b += 5;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("serial="+(endTime-beginTime));
    }

    public static void main(String[] args) throws InterruptedException {
        concurrent();
        serial();

    }
}
