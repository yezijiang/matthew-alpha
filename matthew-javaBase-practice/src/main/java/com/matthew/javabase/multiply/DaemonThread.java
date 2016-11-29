package com.matthew.javabase.multiply;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-07-19 15:11
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(),"daemonRunner");
        thread.setDaemon(true);
        thread.start();
    }
    static class DaemonRunner implements Runnable{
        public void run() {
                System.out.println("Daemon Thread finnally run!");
        }
    }

}
