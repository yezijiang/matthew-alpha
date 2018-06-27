package com.matthew.changpu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-02-28 17:09
 */
public class User implements Serializable {
    private int userId;
    private String userName;
    private int credits;
    private String password;
    private String lastIp;
    private Date lastVisit;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }
}
