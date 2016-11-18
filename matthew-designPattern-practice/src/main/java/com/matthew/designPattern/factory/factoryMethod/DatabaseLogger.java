package com.matthew.designPattern.factory.factoryMethod;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-28 11:57
 */
public class DatabaseLogger implements Logger{
    public DatabaseLogger() {
        System.out.println("数据库连接被建立");
    }

    public void writeLog() {
        System.out.println("数据库日志打印");
    }
}
