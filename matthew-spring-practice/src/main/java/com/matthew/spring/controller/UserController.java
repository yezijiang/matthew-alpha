package com.matthew.spring.controller;

import com.matthew.spring.entity.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-10-09 9:55
 */
public class UserController extends AbstractController{
    /**
     *
     * @param request
     * @param response
     * @return 在请求的最后返回了ModelAndView类型的实例，ModelAndView类在springMVC中占有很重要的地位，控制器执行方法都
     * 必须返回ModelAndView
     * @throws Exception
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<User> userList = new ArrayList<User>();
        User matthew = new User();
        matthew.setUsername("matthew");
        matthew.setAge(27);
        userList.add(matthew);
        User tim = new User();
        tim.setUsername("tim");
        tim.setAge(56);
        userList.add(tim);
        return new ModelAndView("userList","users",userList);
    }
}
