package com.matthew.javabase.multiply;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-09 11:47
 */
public class Profile {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };
    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    public static final long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new BusinessService(),"thread1");
        Thread thread2 = new Thread(new BusinessService(),"thread2");
        thread.start();
        thread2.start();
    }
    static class BusinessService implements Runnable{

        public void run() {
            Profile.begin();
            SleepUtils.second(1);
            System.out.println(Thread.currentThread()+":"+Profile.end());
        }
    }



}
