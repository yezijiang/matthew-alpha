package com.matthew.designPattern.factory.factoryMethod;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-28 11:59
 */
public class DatabaseFactory implements Factory {
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}
