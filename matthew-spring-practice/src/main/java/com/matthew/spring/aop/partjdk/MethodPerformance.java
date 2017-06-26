package com.matthew.spring.aop.partjdk;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-05-10 10:14
 */
public class MethodPerformance {
    private long begin;
    private String serviceMethod;
    public MethodPerformance(String serviceMethod){
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }
    public void printPerformance(){
        long end = System.currentTimeMillis();
        long elapse = end -begin;
        System.out.println(this.serviceMethod+"花费"+elapse+"毫秒");
    }
}
