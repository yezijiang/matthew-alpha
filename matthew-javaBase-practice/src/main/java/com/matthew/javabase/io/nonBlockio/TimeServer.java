/** 
 * Project Name:mypractice 
 * File Name:TimeServer.java 
 * Package Name:com.yaoyaohao.io 
 * Date:2016-1-14下午2:37:19 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
 
package com.matthew.javabase.io.nonBlockio;


/**
 * 
 * @ClassName:  TimeServer   
 * @Description:同步阻塞式创建的TimeServer
 * @author maxing
 * @date:   2016-1-19 下午4:13:28   
 *
 */
public class TimeServer {
	public static void main(String args[]){
		int port=8080;
		if(args!=null&&args.length>0){
			try{
				port=Integer.parseInt(args[0]);
			}catch(NumberFormatException e){
				System.out.println("当前输入值无法赋为port");
			}
		}
		MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
		new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
		
	}

}
   