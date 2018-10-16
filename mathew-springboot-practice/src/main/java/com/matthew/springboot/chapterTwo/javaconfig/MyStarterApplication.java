package com.matthew.springboot.chapterTwo.javaconfig;

import com.yaoyaohao.framework.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2018-07-02 11:50
 */
@RestController
@SpringBootApplication
public class MyStarterApplication {
    HelloService helloService;

    @RequestMapping("/index")
    public String index(){
        return helloService.sayHello();

    }
    public static void main(String[] args) {
        SpringApplication.run(MyStarterApplication.class,args);
    }
}
