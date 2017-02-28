/** 
 * Project Name:mypractice 
 * File Name:TimeClient.java 
 * Package Name:com.yaoyaohao.io.nonBlockioTwo 
 * Date:2016-1-22下午3:35:28 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.io.nonBlockioTwo;

public class TimeClient {
	public static void main(String args[]){
		int port  = 8080;
		if(args!= null&&args.length>0){
			try{
				port = Integer.parseInt(args[0]);
			}catch(NumberFormatException e){
				//不做处理
			}
		}
		new Thread(new AsynTimeClientHandler("127.0.0.1",port),"AIO-AsynTimeClientHanler-001").start();
	}
}
  