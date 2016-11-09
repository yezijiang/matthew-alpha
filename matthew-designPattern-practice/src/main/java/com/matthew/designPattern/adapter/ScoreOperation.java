package com.matthew.designPattern.adapter;

/**
 * 抽象目标
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-18 11:52
 */
public interface ScoreOperation {
    public int[] sort(int array[]);//成绩排序
    public int search(int array[],int key); //成绩查找
}
