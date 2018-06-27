package com.matthew.changpu.service.impl;

import com.matthew.changpu.dao.LoginInDao;
import com.matthew.changpu.dao.UserDao;
import com.matthew.changpu.entity.Loginlog;
import com.matthew.changpu.entity.User;
import com.matthew.changpu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-03-02 11:17
 */
@Service
public class UserServerImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginInDao loginInDao;
    public boolean hasMatchUser(String userName, String password) {
        int matchCount = userDao.getMatchCount(userName,password);
        return matchCount>0;
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    public void loginSuccess(User user) {
        user.setCredits(5+user.getCredits());
        Loginlog loginlog =new Loginlog();
        loginlog.setLoginIp(user.getLastIp());
        loginlog.setLoginDatetime(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginInDao.insertLoginLog(loginlog);
    }
}
