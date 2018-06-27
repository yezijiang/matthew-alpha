package com.matthew.springboot.chapterOne.aop;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2018-05-14 14:31
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
