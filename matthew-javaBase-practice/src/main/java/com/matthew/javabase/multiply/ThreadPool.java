package com.matthew.javabase.multiply;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-12 16:36
 */
public interface ThreadPool<Job extends Runnable> {
    //执行一个job
    void execute(Job job);
    //关闭线程池
    void shutdown();
    //增加工作者线程
    void addWorkers(int num);
    //减少工作者线程
    void removeWorkers(int num);
    //获得正在等待执行的任务数量
    int getJobSize();



}
