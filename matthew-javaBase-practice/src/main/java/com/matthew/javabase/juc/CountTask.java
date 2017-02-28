package com.matthew.javabase.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-06 15:54
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD =2;
    private int start;
    private int end;
    public CountTask(int start,int end){
        this.start = start;
        this.end =end;
    }
    @Override
    protected Integer compute() {
        int sum =0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if(canCompute){
            for(int i=start;i<=end;i++){
                sum +=i;
            }
        }else{
            //如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end)/2;
            CountTask leftCountTask = new CountTask(start,middle);
            CountTask rightCountTask = new CountTask(middle+1,end);
            //执行子任务
            leftCountTask.fork();
            rightCountTask.fork();
            int leftResult = leftCountTask.join();
            int rightResult = rightCountTask.join();
            sum = leftResult+ rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算任务，计算 1+2+3+4+
        CountTask countTask = new CountTask(1,6);
        //执行一个任务
        Future<Integer> result =  forkJoinPool.submit(countTask);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
