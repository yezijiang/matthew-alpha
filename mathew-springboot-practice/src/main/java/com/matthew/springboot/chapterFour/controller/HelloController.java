package com.matthew.springboot.chapterFour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2018-06-26 17:56
 */
@Controller
public class HelloController {
    @RequestMapping("/index")
    public String hello(){
        return "index";
    }
}
