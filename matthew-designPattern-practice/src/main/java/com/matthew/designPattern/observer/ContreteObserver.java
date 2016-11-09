package com.matthew.designPattern.observer;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-27 10:34
 */
public class ContreteObserver implements Observer {
    @Override
    public void update() {
        //相应具体的代码
        System.out.println("检测到被观察者发生变化");
    }
}
