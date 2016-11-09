package com.matthew.designPattern.bridge;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-19 11:20
 */
public class GIFImage extends Image{
    @Override
    public void parseFile(String fileName) {
        //模拟解析GIF文件并获得一个像素矩阵对象m
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName+",格式为GIF");
    }
}
