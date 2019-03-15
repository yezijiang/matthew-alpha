package com.matthew.spring.beanPost;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-02-28 20:29
 */
public class FactoryPostProcesser implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("~~~~~调用了BeanFactoryPostProcessor");
        String[] beanStrs = beanFactory.getBeanDefinitionNames();
        for(String beanName:beanStrs){
            if("beanFactoryPostProcessorTest".equals(beanName)){
                BeanDefinition beanDefinition= beanFactory.getBeanDefinition(beanName);
                System.out.println(beanDefinition.getBeanClassName());
                System.out.println(beanDefinition.getAttribute("name"));
                beanDefinition.setAttribute("name","赵四");
            }
        }
    }
}
