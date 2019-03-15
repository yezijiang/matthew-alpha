package com.matthew.springboot.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.matthew.springboot.dubbapi.IHelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-14 16:14
 */
@RestController
public class HelloController {
	@Reference(interfaceClass = IHelloService.class)
	public IHelloService iHelloService;

	@RequestMapping("/index")
	public @ResponseBody String  index(){
		return iHelloService.sayHello("matthew");
	}
}
