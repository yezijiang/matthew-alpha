package com.matthew.designPattern.observer;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-28 11:06
 */
public class ConcreteAllyControlCenter extends AllyControlCenter {

    public ConcreteAllyControlCenter(String allyName){
        System.out.println("team "+allyName+" is founded");
        System.out.println("------------------------");
        this.allyName = allyName;
    }



    @Override
    public void notifyObserver(String name) {
        System.out.println(this.allyName+"emergency inform,"+name+"is being attacked!");
        //调用观察者列表调用每一个观察者支援
        for(ObserverGamer oberver:players){
            if(!oberver.getName().equalsIgnoreCase(name)){
                oberver.help();
            }
        }
    }
}
