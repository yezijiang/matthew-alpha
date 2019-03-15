package com.matthew.designPattern.adapter;

/**
 * 抽象目标
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-18 11:52
 */
public interface ScoreOperation {
    int[] sort(int array[]);//成绩排序
    int search(int array[],int key); //成绩查找
}
