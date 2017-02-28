package com.matthew.spring.chapter2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-12-07 11:47
 */
public class HelloTest {
    @Test
    public void testHelloWorld(){
        //读取配置文件实例化一个ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/chapter2/helloworld.xml");
        //根据id获取bean
//        HelloApi helloApi = context.getBean("hello", HelloApi.class);
//        helloApi.sayHello();
//        String[] aliasesName = context.getAliases("hello");
//        for(String alias:aliasesName){
//            System.out.println(alias);
//        }
        //使用name也可以获取bean
        HelloApi helloApi = context.getBean("alias2", HelloApi.class);
        helloApi.sayHello();
        HelloApi helloApi2 = context.getBean("hello2", HelloApi.class);
        helloApi2.sayHello();
    }


}
