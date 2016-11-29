package com.matthew.javabase.multiply;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-11 15:54
 */
public class ConnectionPoolTest {
    public static final int THREAD_COUNT=600;
    public static final int GET_COUNT=20;
    public static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;


    public static void main(String[] args) throws InterruptedException {
        end = new CountDownLatch(THREAD_COUNT);
        AtomicInteger get = new AtomicInteger(0);
        AtomicInteger notget = new AtomicInteger(0);
        for(int i = 0;i<THREAD_COUNT;i++){
            Thread thread = new Thread(new ConnectionGetter(get,notget,GET_COUNT));
            thread.start();
        }
        start.countDown();
        /**等待所有线程完成**/
        end.await();
        System.out.println("get connection"+ get);
        System.out.println("not get connection"+ notget);
    }

    static class ConnectionGetter implements Runnable{
        private int count;
        private AtomicInteger get;
        private AtomicInteger notget;
        public ConnectionGetter(AtomicInteger get,AtomicInteger notget,int count){
            this.count = count;
            this.get=get;
            this.notget = notget;
        }

        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
            }
            while(count>0){
                try{
                    Connection connection = pool.fetchConnection(1000);
                    if(connection !=null){
                        connection.createStatement();
                        connection.commit();
                        get.incrementAndGet();
                        pool.releaseConnection(connection);
                    }else{
                        notget.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                     e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                   count--;
                }
            }
            end.countDown();
        }
    }

}
