package com.matthew.javabase.multiply;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**独占锁Mutex 是一个自定义的同步组件
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-19 11:32
 */
public class Mutex implements Lock {
    static class Sync extends AbstractQueuedSynchronizer{



        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(getState() == 0)
                throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() ==1;
        }


        Condition newCondition(){
            return new ConditionObject();
        }
    }


    private static Sync sync = new Sync();

    public void lock() {
        sync.tryAcquire(1);
    }
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    public void unlock() {
        sync.release(1);
    }
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLock(){
        return sync.isHeldExclusively();
    }
    public boolean hasQueuedThreads(){
        return sync.hasQueuedThreads();
    }

    public static void main(String[] args) {
        final Mutex mutex = new Mutex();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mutex.lock();
                System.out.println("拿到了锁");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mutex.lock();
            }
        });
    }
}

