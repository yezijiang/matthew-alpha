package com.matthew.changpu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-02-28 17:42
 */
public class Loginlog implements Serializable {
    private int loginLogId;
    private int userId;
    private String loginIp;
    private Date loginDatetime;

    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDatetime() {
        return loginDatetime;
    }

    public void setLoginDatetime(Date loginDatetime) {
        this.loginDatetime = loginDatetime;
    }
}
