package com.matthew.springboot.chapterOne.service;


import com.matthew.springboot.chapterOne.aop.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2018-04-16 12:19
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(com.matthew.springboot.chapterOne.aop.Action)")
    public void annotationPointCut(){}
    @After("annotationPointCut()")
    public void after(JoinPoint joinpoint){
        MethodSignature signature = (MethodSignature) joinpoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截"+ action.name());
    }
    @Before("execution(* com.matthew.springboot.chapterOne.service.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截"+method.getName());
    }

}
