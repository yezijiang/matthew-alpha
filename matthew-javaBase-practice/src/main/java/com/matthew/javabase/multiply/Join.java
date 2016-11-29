package com.matthew.javabase.multiply;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-09 10:08
 */
public class Join {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        for(int i=0;i<10;i++){
            Domino domino = new Domino(mainThread);
            Thread thread = new Thread(domino,"thread"+i);
            thread.start();
            mainThread = thread;
        }
        System.out.println(Thread.currentThread().getName()+" Terminated");
    }

    static class Domino implements Runnable{
        private Thread thread;
        public Domino(Thread thread){
            this.thread = thread;
        }
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" Terminated");
        }
    }
}
