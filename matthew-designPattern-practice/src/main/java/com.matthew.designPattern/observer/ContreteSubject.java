package com.matthew.designPattern.observer;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-27 10:32
 */
public class ContreteSubject extends Subject{
    //实现通知方法
    @Override
    public void notifyObervers() {
        //便利观察者集合，调用每一个观察者的相应方法
        for(Object obs:observers){
            ((Observer)obs).update();
        }
    }
}
