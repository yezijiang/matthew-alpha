package com.matthew.spring.myselfaop;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-06 16:49
 */
public class LoggerImpl implements Logger {
    @Override
    public void start(Method method) {
        System.out.println("执行切面前方法");
    }

    @Override
    public void end(Method method) {
        System.out.println("执行切面后方法");
    }
}
