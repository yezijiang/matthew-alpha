package com.matthew.spring.chapter3;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-02-09 11:00
 */
public class CircleC {
    private CircleA circleA;

    public void setCircleA(CircleA circleA) {
        this.circleA = circleA;
    }
    public void c(){
        circleA.a();
    }
}
