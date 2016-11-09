package com.matthew.designPattern.observer;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-28 10:53
 */
public class Player implements ObserverGamer {
    public String name;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Player(String name){
        this.name = name;
    }
    /**
     * 支援盟友方法的实现
     */
    @Override
    public void help() {
        System.out.println("hold on!"+name+" is going to cover you.");
    }

    /**
     * 遭受攻击的方法实现，当遭受攻击是，将调用战队控制中心类的通知方法
     * @param acc
     */
    @Override
    public void beAttached(AllyControlCenter acc) {
        System.out.println(name +" is being attached");
        acc.notifyObserver(name);
    }
}
