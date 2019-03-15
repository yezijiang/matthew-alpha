package com.matthew.springboot.dubbservice;

import com.alibaba.dubbo.config.annotation.Service;
import com.matthew.springboot.dubbapi.IHelloService;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-14 11:51
 */
@Service(interfaceClass = IHelloService.class)
@Component
public class HelloServiceImpl implements IHelloService {
	@Override
	public String  sayHello(String name) {
		return "服务调用。hello," + name;
	}
}
