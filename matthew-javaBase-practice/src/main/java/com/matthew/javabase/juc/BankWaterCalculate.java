package com.matthew.javabase.juc;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-08 14:43
 */
public class BankWaterCalculate implements Runnable{
    //创建四个屏障，处理完之后执行当前的run方法。
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4,this);
    private Executor executor = Executors.newFixedThreadPool(4);
    private ConcurrentHashMap<String,Integer> sheetBankWaterCount = new ConcurrentHashMap<String, Integer>();

    public void count(){
        for(int i=1;i<=4;i++){
            executor.execute(new Thread(new Runnable() {
                public void run() {
                    sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
    }

    public void run() {
        int result = 0;
        //当4个sheet计算完成之后，汇总四个sheet的计算结果
        for(Map.Entry<String,Integer> sheet:sheetBankWaterCount.entrySet()){
            result += sheet.getValue();
        }
        //将结果输出
        sheetBankWaterCount.put("result",result);
        System.out.println(sheetBankWaterCount.get("result"));

    }

    public static void main(String[] args) {
        BankWaterCalculate bankWaterCalculate = new BankWaterCalculate();
        bankWaterCalculate.count();
    }
}
