package com.matthew.spring.chapter3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-02-09 17:32
 */
public class ResourceBean {
    private FileOutputStream fos;
    private File file;

    public void init(){
        System.out.println("ResourceBean: === 初始化");
        //加载资源
        System.out.println("ResourceBean: ==== 加载资源进行一些初始化操作。");
        try {
            this.fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void destroy(){
        System.out.println("ResourceBean:====销毁");
        //释放资源
        System.out.println("ResourceBean:====释放资源，执行一些清理操作");
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileOutputStream getFos() {
        return fos;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
