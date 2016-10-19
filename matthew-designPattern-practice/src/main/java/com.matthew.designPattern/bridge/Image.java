package com.matthew.designPattern.bridge;

/**抽象图像类:抽象类
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-19 11:02
 */
public abstract class Image {
    protected ImageImp imp;
    public void setImageImp(ImageImp imp){
        this.imp = imp;
    }
    public abstract void parseFile(String fileName);
}
