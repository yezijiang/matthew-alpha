package com.matthew.designPattern.prototype;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-11 14:15
 */
public class Attachment implements Cloneable{
    public String name;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String filePath;


}
