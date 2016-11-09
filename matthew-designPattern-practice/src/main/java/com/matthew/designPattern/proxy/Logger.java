package com.matthew.designPattern.proxy;

/**
 *  日志记录类，业务类，提供记录日志的方法，方便月末金额计算。
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-20 17:14
 */
public class Logger {
    public void log(String userId,String keyword){
        System.out.println("用户"+"查询"+keyword+"增加一次");
    }
}
