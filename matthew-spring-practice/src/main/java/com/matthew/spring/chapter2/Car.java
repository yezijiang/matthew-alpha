package com.matthew.spring.chapter2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**管理bean生命周期的接口
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-03-08 17:31
 */
public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{

    private String brand;
    private String color;
    private int maxSpeed;
    private String iDCode;

    private BeanFactory beanFactory;
    private String beanName;

    public Car(){
        System.out.println("Car初始化");
    }

    public void setBrand(String brand){
        System.out.println("调用setBrand()设置属性");
        this.brand = brand;
    }
    public void introduce(){
        System.out.println("brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", iDCode='" + iDCode + '\'' +
                ", maxSpeed=" + maxSpeed );
    }
    //BeanFactoryAware接口方法
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }
    //BeanNameAware接口方法
    public void setBeanName(String name) {
        System.out.println("调用BeanNameAware.setBeanName().");
        this.beanName = name;
    }
    //DisposableBean接口方法
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destroy().");
    }
    //InitializingBean接口方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()");
    }
    //通过<bean>的init-method属性指定的初始化方法
    public void myInit(){
        System.out.println("调用init-method所指定的myInit()，将maxSpeed设置为240");
        this.maxSpeed = 240;
    }
    //通过bean的destroy-method属性指定的销毁方法。
    public void myDestroy(){
        System.out.println("调用destroy-mehtod所指定的myDestroy");
    }
    public String getColor() {
        return color;
    }
    public String getBrand() {
        return brand;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setIDCode(String iDCode) {
        this.iDCode = iDCode;
    }
}
