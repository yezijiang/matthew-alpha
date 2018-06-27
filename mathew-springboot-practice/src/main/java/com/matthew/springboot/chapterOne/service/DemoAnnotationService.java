package com.matthew.springboot.chapterOne.service;

import com.matthew.springboot.chapterOne.aop.Action;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2018-04-16 12:14
 */
@Service
public class DemoAnnotationService {
    @Action(name="注解式拦截的add操作")
    public void add(){}
}
