package com.matthew.javabase.lang.reflect;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-07-31 13:22
 */
public class Car {
    private String brand;
    private String color;
    private int maxSpeed;

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void introduce(){
        System.out.println("brand:"+brand+";\ncolor:"+color+";\nmaxSpeed:"+this.maxSpeed);
    }

    public static void main(String[] args) {
        Car myNewCar = new Car("benz","white",220);
        myNewCar.introduce();
    }
}
