package com.matthew.changpu.service;

import com.matthew.changpu.BaseTest;
import com.matthew.changpu.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-03-06 11:36
 */
public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;
    @Test
    public void hasMatchCount(){
        boolean rtOne = userService.hasMatchUser("admin","password");
        boolean rtTwo = userService.hasMatchUser("admin","123456");
        System.out.println(rtOne);
        System.out.println(rtTwo);
    }
    @Test
    public void findUserByUsername(){
        User user = userService.findUserByUserName("admin");
        System.out.println(user.getUserName());
    }
}
