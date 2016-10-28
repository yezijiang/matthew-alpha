package com.matthew.designPattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-28 15:46
 */
public class Investor implements Observer {
    public String userName;

    public Investor(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(userName+"股票价格的雪崩，朕知道了！");
        System.out.println(arg.toString());
    }
}
