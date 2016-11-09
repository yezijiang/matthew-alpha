package com.matthew.designPattern.bridge;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-19 11:12
 */
public class UnixImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) {
        //使用unix系统的绘制函数绘制像素矩阵
        System.out.println("在unix操作系统中显示图像。");
    }
}
