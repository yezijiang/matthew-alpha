package com.matthew.spring.beanPost;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-02-28 20:39
 */
public class Test {
    ApplicationContext applicationContext;
    @Before
    public void before(){
        System.out.println("》》》Spring ApplicationContext容器开始初始化了");
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"config/spring-service.xml"});
        System.out.println("》》》Spring ApplicationContext容器初始化结束了");
    }
    @org.junit.Test
    public void test(){
        System.out.println("开始测试了");
        BeanFactoryPostProcessorTest beanFactoryPostProcessorTest = applicationContext.getBean(BeanFactoryPostProcessorTest.class);
        System.out.println(beanFactoryPostProcessorTest.toString());

    }
}
