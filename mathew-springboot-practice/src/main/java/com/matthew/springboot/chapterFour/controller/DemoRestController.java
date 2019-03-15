package com.matthew.springboot.chapterFour.controller;

import com.matthew.springboot.chapterFour.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-02-19 9:47
 */
//组合注解，组合了@Controller和@ResponseBody
@RestController
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping
    public String index(HttpServletRequest request) {
        return "url" + request.getRequestURL() + " can access.";
    }
    @RequestMapping(value = "/getjson",produces = {"application/json;charset=UTF-8"})
    public DemoObj index(DemoObj demoObj,HttpServletRequest request) {
        return new DemoObj(demoObj.getId()+1,demoObj.getName()+"yy");
    }

}
