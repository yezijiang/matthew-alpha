package com.matthew.javabase.multiply;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-23 15:26
 */
public class TwinsLock implements Lock {
    private final Sync sync = new Sync(2);
    private static final class Sync extends AbstractQueuedSynchronizer{
        Sync(int count){
            if(count <=0){
                throw new IllegalArgumentException("count must large than zero.");

            }
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int reduceCount) {
            for(;;){
                int current = getState();
                int newCount = current - reduceCount;
                if(newCount<0 || compareAndSetState(current,newCount)){
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int returnCount) {
            for(;;){
                int current = getState();
                int newcount = current + returnCount;
                if(compareAndSetState(current,newcount)){
                    return true;
                }
            }
        }
    }


    public void lock() {
        sync.tryAcquireShared(1);
    }

    public void lockInterruptibly() throws InterruptedException {

    }

    public boolean tryLock() {
        return false;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public void unlock() {
        sync.tryReleaseShared(1);
    }

    public Condition newCondition() {
        return null;
    }
}
