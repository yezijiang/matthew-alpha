package com.matthew.springboot.dubbservice;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDubboConfiguration
@SpringBootApplication
public class DubbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubbServiceApplication.class, args);
	}

}
