package com.matthew.javabase.juc;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-01 15:11
 */
public class People extends Mammal{

    public volatile int weight;

    private String nickName;
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public People(int weight, String nickName) {
        this.weight = weight;
        this.nickName = nickName;
    }
}
