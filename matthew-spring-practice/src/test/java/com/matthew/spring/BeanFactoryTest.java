package com.matthew.spring;

import com.matthew.spring.chapter2.Car;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2018-07-18 19:34
 */
@SuppressWarnings("deprecation")
public class BeanFactoryTest {
    @Test
    public void testSimpleLoad(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("conf/beanFactoryTest.xml"));
        Car car  = (Car) beanFactory.getBean("car");
        System.out.println(car.getColor());
        assertEquals("this value is not what we expected.","green",car.getColor());

    }
}