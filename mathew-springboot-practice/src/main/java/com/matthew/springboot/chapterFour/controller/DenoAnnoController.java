package com.matthew.springboot.chapterFour.controller;

import com.matthew.springboot.chapterFour.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-02-19 9:20
 */
@Controller
@RequestMapping("/anno")
public class DenoAnnoController {

    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String index(HttpServletRequest request){
        return "url"+request.getRequestURL()+" can access.";

    }


    @RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String demoPathVar(@PathVariable String str,HttpServletRequest request){
        return "url"+request.getRequestURL()+" can access,"+str;

    }

    @RequestMapping(value = "/requestParam",produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String passRequestParam(Long id,HttpServletRequest request){
        return "url"+request.getRequestURL()+" can access， id："+id;

    }

    @RequestMapping(value = "/obj")
    @ResponseBody
    public String passObj(DemoObj demoObj,HttpServletRequest request){
        return "url"+request.getRequestURL()+" can access，obj id："+demoObj.getId()+" obj name:"+demoObj.getName();
    }

}
