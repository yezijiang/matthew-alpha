/** 
 * Project Name:mypractice 
 * File Name:DemoService.java 
 * Package Name:com.yaoyoahao.dubbo 
 * Date:2016-1-27下午3:15:44 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.spring.dubbo;
import java.util.List;

public interface DemoService {  
	  
    String sayHello(String name);  
  
    public List getUsers();  
  
}  