/** 
 * Project Name:myPratice 
 * File Name:Counter.java 
 * Package Name:com.yaoyaohao.multiply 
 * Date:2015-12-2下午2:31:11 
 * Copyright (c) 2015, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.multiply;

public class Counter {
	 
    public  static int count = 0;
 
    public static void inc() {
 
        //这里延迟1毫秒，使得结果明显
        count++;
    }
 
    public static void main(String[] args) {
 
        //同时启动1000个线程，去进行i++计算，看看实际结果
 
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    Counter.inc();
                }
            }).start();
        }
 
        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + Counter.count);
    }
}