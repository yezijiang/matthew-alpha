package com.matthew.designPattern.observer;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-28 10:53
 */
public abstract class AllyControlCenter {
    public String allyName;//战队名称
    public ArrayList<ObserverGamer> players = new ArrayList<ObserverGamer>();
    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    public void join(ObserverGamer observer){
        System.out.println(observer.getName()+" joins "+this.allyName);
        players.add(observer);
    }

    public void quit(ObserverGamer observer){
        System.out.println(observer.getName()+" quit "+this.allyName);
    }
    //声明抽象通知方法
    public abstract void notifyObserver(String name);
}
