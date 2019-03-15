package com.matthew.springboot.dubboconsumer.main;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableDubboConfiguration
@SpringBootApplication(scanBasePackages = "com.matthew.springboot.dubboconsumer")
public class DubbConsumerApplication {

		public static void main(String[] args) {
			ConfigurableApplicationContext run=SpringApplication.run(DubbConsumerApplication.class, args);

	}

}
