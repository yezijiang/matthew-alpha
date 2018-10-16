package com.matthew.javabase.juc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-30 15:14
 */
public class ConcurrentHashMapTest {

    public static final  Map concurrentMap = new ConcurrentHashMap<String,String>();
    public static void main(String[] args) {
      Map concurrentMap = new ConcurrentHashMap<String,String>();
        concurrentMap.put("name","lili");
        concurrentMap.put("age","15");
        concurrentMap.put("age1","15");
        concurrentMap.put("age2","15");
        concurrentMap.put("age3","15");
        concurrentMap.put("age4","15");
        concurrentMap.put("age5","15");
        concurrentMap.put("age6","15");
        concurrentMap.put("age7","15");
        concurrentMap.put("age8","15");
        concurrentMap.put("age9","15");
        concurrentMap.put("age10","15");
        concurrentMap.put("age11","15");
        concurrentMap.put("age12","15");
        concurrentMap.put("age13","15");
        concurrentMap.put("age14","15");
        concurrentMap.put("age15","15");
        concurrentMap.put("age16","15");

    }
  public void multiThreadTest(){
    Thread threadOne = new Thread(new Runnable() {
      @Override
      public void run() {
        concurrentMap.put("age", "15");
        concurrentMap.put("age1", "15");
        concurrentMap.put("age2", "15");
      }
    });
    Thread threadTwo = new Thread(new Runnable() {
      @Override
      public void run() {
        concurrentMap.put("age", "15");
        concurrentMap.put("age1", "15");
        concurrentMap.put("age2", "15");
      }
    });
    threadOne.start();
    threadTwo.start();
    System.out.println("打印开始");
  }

}
