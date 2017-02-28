package com.matthew.spring.chapter3;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-02-09 11:00
 */
public class CircleA {
    private CircleB circleB;

    public void setCircleB(CircleB circleB) {
        this.circleB = circleB;
    }
    public void a(){
        circleB.b();
    }
}

