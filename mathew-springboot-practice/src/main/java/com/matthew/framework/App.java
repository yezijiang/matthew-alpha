package com.matthew.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 在这里我们使用@springBootApplication指定这是一个spring boot的应用程序
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-06-22 18:45
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);

    }
}
