package com.matthew.designPattern.bridge;

/**
 * windows操作系统实现类
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-19 11:06
 */
public class WindowsImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) {
        //调用windows系统的绘制像素矩阵
        System.out.println("在windows操作系统中显示图像。");
    }
}
