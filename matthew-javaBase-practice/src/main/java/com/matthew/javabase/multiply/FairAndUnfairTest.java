package com.matthew.javabase.multiply;


import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-26 16:11
 */
public class FairAndUnfairTest {
    public static Lock fairLock = new ReentrantLock2(true);
    public static Lock noFairLock = new ReentrantLock2(false);

    @Test
    public void testFair(){
        testLock(fairLock);
    }
    @Test
    public void testNofair(){
        testLock(noFairLock);
    }


    public void testLock(Lock lock){
        //启动5个job
        for(int i=0;i<5;i++){
            Job job = new Job(lock);
            job.start();
        }


    }

    private static class Job extends Thread{
        private Lock lock;
        public Job(Lock lock){
            this.lock = lock;
        }
        public void run(){
            lock.lock();
            //连续2次打印当前的Thread和等待队列中的Thread
            System.out.print("lock by ["+Thread.currentThread().getName()+"]    ");
            Collection<Thread> waitThreadList = ((ReentrantLock2)lock).getQueuedThreads();
            StringBuffer waiting = new StringBuffer("waiting by [");
            for(Thread waitThread :waitThreadList){
                waiting.append(waitThread.getName()).append(",");
            }
            waiting.append("]");
            System.out.println(waiting.toString());

            //连续2次打印当前的Thread和等待队列中的Thread
            System.out.print("lock by ["+Thread.currentThread().getName()+"]     ");
            waitThreadList = ((ReentrantLock2)lock).getQueuedThreads();
            waiting = new StringBuffer("waiting by [");
            for(Thread waitThread :waitThreadList){
                waiting.append(waitThread.getName()).append(",");
            }
            waiting.append("]");
            System.out.println(waiting.toString());
            lock.unlock();
        }
    }

    private static class ReentrantLock2 extends ReentrantLock{
        public ReentrantLock2(boolean fair){
            super(fair);
        }
        public Collection<Thread> getQueuedThreads(){
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
