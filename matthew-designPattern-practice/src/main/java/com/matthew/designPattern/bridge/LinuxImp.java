package com.matthew.designPattern.bridge;

/**Linux操作系统实现类
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-19 11:10
 */
public class LinuxImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) {
        //调用linux系统的绘制函数绘制像素矩阵
        System.out.println("在linux操作系统中显示图像。");
    }
}
