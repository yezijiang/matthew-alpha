package com.matthew.javabase.multiply;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-09 15:33
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<Connection>();

    /**初始化连接池**/
    public ConnectionPool(int initialSize){
        if(initialSize>0){
            for(int i=0;i<initialSize;i++){
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }
    public void releaseConnection(Connection connection){
        if(connection != null){
            synchronized (pool){
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }
    /****/
    public  Connection fetchConnection(long millisecond) throws InterruptedException {
        synchronized (pool){
            if(millisecond <= 0){
                while(pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else{
                long future = System.currentTimeMillis()+millisecond;
                long remaining = millisecond;
                /**即 在pool为empty时，如果在等待时间内没有获取到connection 就放弃循环等待**/
                while(pool.isEmpty()&&remaining>0){
                    pool.wait(millisecond);
                    remaining = future - System.currentTimeMillis();
                }
                Connection connection = null;
                if(!pool.isEmpty()){
                    connection = pool.removeFirst();
                }
                return connection;

            }
        }

    }
    public static void main(String[] args) {

    }
}
