package com.matthew.spring.chapter3;

import com.matthew.spring.chapter2.HelloApi;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-12-07 11:47
 */
public class DependentTest {
    @Test
    public void testHelloWorld() throws IOException {
        //读取配置文件实例化一个ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/chapter3/depends-on.xml");
        DependentBean dependentBean = context.getBean("dependentBean", DependentBean.class);
        dependentBean.write("aaa");
    }


}
