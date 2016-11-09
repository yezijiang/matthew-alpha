package com.matthew.designPattern.observer;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-27 10:39
 */
public class Cient{
    public static void main(String[] args) {
        //client for part one
//        Subject oneSubject = new ContreteSubject();
//        Observer car = new ContreteObserver();
//        oneSubject.attach(car);
//        oneSubject.attach(car);
//        oneSubject.detach(car);
//        oneSubject.notifyObervers();

//        //client for part two
//        //定义观察目标对象
//        AllyControlCenter acc;
//        acc = new ConcreteAllyControlCenter("金庸群侠");
//
//        //定义四个观察者对象
//        ObserverGamer player1,player2,player3,player4;
//        player1 = new Player("杨过");
//        acc.join(player1);
//        player2 = new Player("令狐冲");
//        acc.join(player2);
//        player3 = new Player("张无忌");
//        acc.join(player3);
//        player4 = new Player("段誉");
//        acc.join(player4);
//        player1.beAttached(acc);

        //client for part three
        Shares oneShare = new Shares("A001","安琪酵母",100d);
        Investor tim = new Investor("tim");
        Investor steven = new Investor("steven");
        oneShare.addObserver(tim);
        oneShare.addObserver(steven);
        oneShare.setPrice(92d);


//        ArrayList<String> stringlist = new ArrayList<String>();
//        stringlist.add("a");
//        stringlist.add("b");
//        stringlist.add("c");
//        stringlist.add("d");
//        stringlist.remove("b");
    }

}
