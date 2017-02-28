package com.matthew.javabase.lang;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-24 11:56
 */
public  class User implements Serializable{

    private static final long serialVersionUID = -4680181179696246626L;
    public static String userName;
    public transient String password;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
