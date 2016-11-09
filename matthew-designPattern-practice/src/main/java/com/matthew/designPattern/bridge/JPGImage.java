package com.matthew.designPattern.bridge;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-19 11:13
 */
public class JPGImage extends Image {
    @Override
    public void parseFile(String fileName) {
        //模拟解析JPG文件并获取一个像素矩阵对象m
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName +",格式为Jpg");
    }
}
