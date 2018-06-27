package com.matthew.changpu.controller.sys;

import com.matthew.changpu.entity.User;
import com.matthew.changpu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-03-06 17:13
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage(){return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView loginCheck(HttpServletRequest request,Model model){
        String username = request.getParameter("username").toString();
        String password = request.getParameter("password").toString();
        boolean isValidUser = userService.hasMatchUser(username,password);
        if(!isValidUser){
            return new ModelAndView("login","errpr","用户名密码错误");
        }else{
            User user = userService.findUserByUserName(username);
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("index");
        }
    }
}
