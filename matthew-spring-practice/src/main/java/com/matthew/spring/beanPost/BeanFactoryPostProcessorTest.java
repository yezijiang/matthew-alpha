package com.matthew.spring.beanPost;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-02-28 20:35
 */
public class BeanFactoryPostProcessorTest implements InitializingBean,DisposableBean,BeanNameAware,BeanFactoryAware {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("》》》调用了beanFactoryAware的setBeanFactory方法了");
    }

    public void setBeanName(String name) {
        System.out.println("》》》调用了beanNameAware的setBeanName方法了");
    }

    public void destroy() throws Exception {
        System.out.println("》》》调用了DisposableBean的destory方法了");

    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("》》》调用了InitializingBean的afterPropertiesSet方法了");

    }

    @Override
    public String toString() {
        return "BeanFactoryPostProcessorTest{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
