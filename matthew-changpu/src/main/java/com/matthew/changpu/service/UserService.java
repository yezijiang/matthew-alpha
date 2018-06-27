package com.matthew.changpu.service;

import com.matthew.changpu.entity.User;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-03-02 11:06
 */
public interface UserService {
    boolean hasMatchUser(String userName,String password);
    User findUserByUserName(String userName);
    void loginSuccess(User user);
}
