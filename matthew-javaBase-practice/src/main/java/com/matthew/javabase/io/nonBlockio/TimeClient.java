/** 
 * Project Name:mypractice 
 * File Name:TimeClient.java 
 * Package Name:com.yaoyaohao.io.nonBlockio 
 * Date:2016-1-21下午2:33:22 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.io.nonBlockio;

public class TimeClient {
	public static void main(String args[]){
		int port = 8080;
		if(args!=null&&args.length>0){
			port = Integer.parseInt(args[0]);
		}
		new Thread(new TimeClientHandle("127.0.0.1",port),"TimeClient-001").start();
	}

}
  