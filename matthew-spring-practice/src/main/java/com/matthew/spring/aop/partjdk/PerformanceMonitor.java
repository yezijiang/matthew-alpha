package com.matthew.spring.aop.partjdk;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-05-10 10:01
 */
public class PerformanceMonitor {
    //通过一个ThreadLocal保存线程相关的性能监控信息
    private static ThreadLocal<MethodPerformance> performanceRecord= new ThreadLocal<MethodPerformance>();
    public static void begin(String method){
        System.out.println("开始监控");
        MethodPerformance mp = new MethodPerformance(method);
        performanceRecord.set(mp);
    }
    public static void end(){
        System.out.println("结束监控");
        MethodPerformance mp = performanceRecord.get();
        mp.printPerformance();
    }
}
