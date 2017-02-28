package com.matthew.spring.chapter3;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-02-09 11:00
 */
public class CircleB {
    private CircleC circleC;

    public void setCircleC(CircleC circleC) {
        this.circleC = circleC;
    }
    public void b(){
        circleC.c();
    }
}
