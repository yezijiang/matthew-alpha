/** 
 * Project Name:mypractice 
 * File Name:Lili.java 
 * Package Name:com.yaoyaohao.lang 
 * Date:2016-2-18下午3:11:43 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.lang;

public class Lili extends People{
	public String name="lili";
	public Lili(){
		System.out.println("子类构造函数--开始");
		System.out.println(this.name);
		this.name = "lili zhou";
		System.out.println("子类构造函数--结束");
	}
	
	public static void main(String args[]){
		System.out.println(new Lili().name);
	}
	static{
		System.out.println("开始子类静态块加载");
	}
}
  