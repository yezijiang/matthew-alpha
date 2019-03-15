package com.matthew.spring.aop.sourceCode;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2018-10-29 15:14
 */
@Aspect
public class Aspectj {
    @Pointcut("execution(* *.test(..))")
    public void test(){}

    @Before("test()")
    public void beforeTest(){
        System.out.println("before");
    }
    @After("test()")
    public void aferTest(){
        System.out.println("after");
    }
    @Around("test()")
    public Object arountTest(ProceedingJoinPoint joinPoint){
        System.out.println("before  around");
        Object o = null;
        try {
            o = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after around");
        return o;
    }
}
