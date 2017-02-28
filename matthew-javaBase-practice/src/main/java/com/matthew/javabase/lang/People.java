/** 
 * Project Name:mypractice 
 * File Name:People.java 
 * Package Name:com.yaoyaohao.lang 
 * Date:2016-2-18下午3:11:01 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.lang;

public class People {
	public int age=20;
	public People(){
		System.out.println("父类构造函数--开始");
		System.out.println("打印"+((Lili)this).name);
		System.out.println("打印"+((Lili)this).age);
		System.out.println("父类构造函数--结束");
	}
	static{
		System.out.println("开始父类静态块加载");
	}
}
  