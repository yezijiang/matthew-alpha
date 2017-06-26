package com.matthew.spring.chapter2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-03-21 15:44
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            Car aCar = (Car)bean;
            if(null == aCar.getColor()){
                System.out.println("调用BeanPostProcessor.postProcessBeforeInitialization() color为空 设置为默认黑色。");
                aCar.setColor("黑色");
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            Car car = (Car)bean;
            if(car.getMaxSpeed()>200){
                car.setMaxSpeed(200);
            }
        }
        return bean;
    }
}
