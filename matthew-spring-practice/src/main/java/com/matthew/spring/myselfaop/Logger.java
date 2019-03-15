package com.matthew.spring.myselfaop;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-06 16:48
 */
public interface Logger {
    void start(Method method);
    void end(Method method);
}
