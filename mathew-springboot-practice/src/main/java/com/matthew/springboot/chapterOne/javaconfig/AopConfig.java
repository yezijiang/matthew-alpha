package com.matthew.springboot.chapterOne.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2018-05-14 14:43
 */
@Configuration
@ComponentScan("com.matthew.springboot")
@EnableAspectJAutoProxy
public class AopConfig {
}
