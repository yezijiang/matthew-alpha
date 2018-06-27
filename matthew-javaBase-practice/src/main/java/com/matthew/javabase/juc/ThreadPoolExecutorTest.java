package com.matthew.javabase.juc;

import com.matthew.javabase.lang.*;
import com.matthew.javabase.lang.People;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-08-25 16:00
 */
public class ThreadPoolExecutorTest {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    private final static AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static int ctlOf(int rs, int wc) { return rs | wc; }
    public static void printSystemParam(){
        System.out.println(COUNT_BITS);
        System.out.println(RUNNING);
        System.out.println(Integer.toBinaryString(RUNNING));
        System.out.println(CAPACITY);
        System.out.println(Integer.toBinaryString(CAPACITY));
        System.out.println(Integer.toBinaryString(~CAPACITY));
        System.out.println(Integer.toBinaryString(ctl.get()));
        System.out.println(ctl.get() & CAPACITY);
    }

    public static void testSubmit(){
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Future<People> retPeople = pool.submit(new Callable<People>() {
            @Override
            public People call() throws Exception {
                com.matthew.javabase.lang.People marthin = new People();
                marthin.age=12;
                return marthin;
            }
        });
        try {
            System.out.println(retPeople.get().age);;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println(0x7fffffff);
        ExecutorService zeroExecutor= new ThreadPoolExecutor(0,0,60L,TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        zeroExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111");
            }
        });
    }
}
