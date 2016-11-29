package com.matthew.javabase.multiply;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-12 16:52
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    //默认的工作者数量
    private static final int WORKER_DEFAULT_NUM = 5;
    //最大工作者数量
    private static final int WORKER_MAX_NUM = 10;
    //最小工作者数量
    private static final int WORKER_MIN_NUM = 1;
    //工作者列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    //工作列表
    private final LinkedList<Job> jobs = new LinkedList<Job>();
    //工作者线程数量
    private int workerNum = WORKER_DEFAULT_NUM;
    //线程编号的生成
    private AtomicInteger threadNum = new AtomicInteger();

    public DefaultThreadPool(){
        initializeWorker(WORKER_DEFAULT_NUM);
    }
    public DefaultThreadPool(int num){
        workerNum = num>WORKER_MAX_NUM?WORKER_MAX_NUM:num<WORKER_MIN_NUM?WORKER_MIN_NUM:num;
        initializeWorker(workerNum);
    }


    public void execute(Job job) {
        if(job !=null){
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    public void shutdown() {
        for(Worker worker:workers){
            worker.shutdown();
        }
    }

    public void addWorkers(int num) {
        synchronized (jobs){
            if(num+workerNum>WORKER_MAX_NUM){
                num = WORKER_MAX_NUM - workerNum;
            }
            initializeWorker(num);
            this.workerNum +=num;
        }
    }

    public void removeWorkers(int num) {
        synchronized (jobs){
            if(num >= this.workerNum){
                throw new IllegalArgumentException("beyond workNum");
            }
            int count =0;
            while(count<num){
                Worker worker = workers.get(count);
                if(workers.remove(worker)){
                    worker.shutdown();
                    count--;
                }
            }
            this.workerNum -=count;
        }
    }

    public int getJobSize() {
        return jobs.size();
    }

    public void initializeWorker(int num){
        for(int i =0;i<num;i++){
            Worker worker  = new Worker();
            workers.add(worker);
            Thread thread  = new Thread(worker,"ThreadPool-Worker-"+threadNum.incrementAndGet());
            thread.start();
        }

    }
    class Worker implements Runnable{
        private volatile boolean running = true;
        public void run() {
            while(running){
                Job job = null;
                synchronized (jobs){
                    while(jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().isInterrupted();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if(job != null){
                    job.run();
                }
            }
        }
        public void shutdown(){
            this.running = false;
        }
    }
}
