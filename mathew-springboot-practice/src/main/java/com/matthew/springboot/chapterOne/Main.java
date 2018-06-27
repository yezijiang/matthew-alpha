package com.matthew.springboot.chapterOne;

import com.matthew.springboot.chapterOne.javaconfig.AopConfig;
import com.matthew.springboot.chapterOne.service.DemoAnnotationService;
import com.matthew.springboot.chapterOne.service.DemoMethodService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2018-05-14 14:45
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService =
                context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService =
                context.getBean(DemoMethodService.class);
        demoAnnotationService.add();
        demoMethodService.add();
        context.close();
    }
}
