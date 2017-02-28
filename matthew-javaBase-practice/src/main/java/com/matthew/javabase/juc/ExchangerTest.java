package com.matthew.javabase.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-08 15:45
 */
public class ExchangerTest {
    private static Exchanger<String> exchanger = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Thread(new Runnable() {
            public void run() {
                String str1 = "线程A啊";
                try {
                    System.out.println(exchanger.exchange(str1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }));

        threadPool.execute(new Thread(new Runnable() {
            public void run() {
                String str2 = "线程B啊";
                System.out.println(str2);
                try {
                    Thread.currentThread().sleep(1000);
                    System.out.println("线程B："+exchanger.exchange(str2));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
    }
}
