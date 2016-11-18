package com.matthew.designPattern.factory.factoryMethod;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-28 11:56
 */
public class FileLogger implements Logger {
    public void writeLog() {
        System.out.println("文件日志打印");
    }
}
