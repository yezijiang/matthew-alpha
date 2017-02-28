package com.matthew.spring.chapter3;

import com.matthew.spring.chapter2.HelloApi;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-12-07 11:47
 */
public class HelloTest {
    @Test
    public void testHelloWorld(){
        //读取配置文件实例化一个ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/chapter3/helloworld.xml");
        HelloApi hello3= context.getBean("hello3",HelloApi.class);
        hello3.sayHello();

        HelloApi factoryBeanHello3 = context.getBean("factoryBeanHello3",HelloApi.class);
        factoryBeanHello3.sayHello();

        HelloApi setterHello4 = context.getBean("hello4",HelloApi.class);
        setterHello4.sayHello();

        ListBean listBean  = context.getBean("listBean",ListBean.class);
        for(String value:listBean.getValues()){
            System.out.println(value);
        }

        MapBean mapBean = context.getBean("mapBean",MapBean.class);
        System.out.println(mapBean.getKeyValues().get("word"));

        PropertiesBean propertiesBean = context.getBean("propertiesBean",PropertiesBean.class);
        System.out.println(propertiesBean.getValues().get("word"));

        HelloApiDecorator helloApiDecorator1 = context.getBean("helloApiDecorator1",HelloApiDecorator.class);
        helloApiDecorator1.sayHello();
        HelloApiDecorator helloApiDecorator2 = context.getBean("helloApiDecorator2",HelloApiDecorator.class);
        helloApiDecorator2.sayHello();
    }


}
