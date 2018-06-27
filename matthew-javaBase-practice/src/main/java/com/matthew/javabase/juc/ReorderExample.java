package com.matthew.javabase.juc;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-09-15 17:15
 */
public class ReorderExample {
    int a =0;
    boolean  flag = true;
    public void writer(){
        a =1;
        flag = false;
    }
    public CyclePrint getCyclePrint() {
        return new CyclePrint();
    }

    public class CyclePrint implements Runnable{

        @Override
        public void run() {
            while(flag){
                System.out.println("111111");
                System.out.println(flag);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {

        ReorderExample reorderExample = new ReorderExample();

        Thread cyclePrint = new Thread(reorderExample.getCyclePrint());
        cyclePrint.start();
        Thread.currentThread().sleep(111L);
        reorderExample.writer();


    }


}
