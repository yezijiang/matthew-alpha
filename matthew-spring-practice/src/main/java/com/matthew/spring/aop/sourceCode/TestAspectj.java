package com.matthew.spring.aop.sourceCode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2018-10-29 15:27
 */
public class TestAspectj {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        TestBean testBean = (TestBean)applicationContext.getBean("test");
        testBean.test();
    }
}
