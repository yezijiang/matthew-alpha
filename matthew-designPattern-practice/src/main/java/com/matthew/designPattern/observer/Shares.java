package com.matthew.designPattern.observer;

import java.util.Observable;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-28 15:45
 */
public class Shares extends Observable {
    public String shareCode;
    public String shareName;
    public Double price;

    public Shares(String shareCode, String shareName, Double price) {
        this.shareCode = shareCode;
        this.shareName = shareName;
        this.price = price;
    }

    public String getShareCode() {
        return shareCode;
    }

    public void setShareCode(String shareCode) {
        this.shareCode = shareCode;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double newPrice) {
        if((price-newPrice)/price>=0.05){
            super.setChanged();
            super.notifyObservers(newPrice);
        }
        this.price = price;
    }
}
