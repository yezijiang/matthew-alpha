/** 
 * Project Name:mypractice 
 * File Name:DemoServiceImpl.java 
 * Package Name:com.yaoyoahao.dubbo 
 * Date:2016-1-27下午3:19:22 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.spring.dubbo;

import java.util.ArrayList;
import java.util.List;

public class DemoServiceImpl implements DemoService{

	public String sayHello(String name) {
		 return "Hello " + name;  
	}

	public List getUsers() {
	     List list = new ArrayList();  
	     User u1 = new User();  
	     u1.setName("jack");  
	     u1.setAge(20);  
	     u1.setSex("男");  
	       
	     User u2 = new User();  
	     u2.setName("tom");  
	     u2.setAge(21);  
	     u2.setSex("女");  
	       
	     User u3 = new User();  
	     u3.setName("rose");  
	     u3.setAge(19);  
	     u3.setSex("女");  
	       
	     list.add(u1);  
	     list.add(u2);  
	     list.add(u3);  
	     return list;  
	    
	}

}
  