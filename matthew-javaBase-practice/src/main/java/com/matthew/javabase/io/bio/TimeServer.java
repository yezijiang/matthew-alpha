/** 
 * Project Name:mypractice 
 * File Name:TimeServer.java 
 * Package Name:com.yaoyaohao.io 
 * Date:2016-1-14下午2:37:19 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
 
package com.matthew.javabase.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
		ServerSocket server= null;
		try {
			server = new ServerSocket(port);
			System.out.println("The time server is start in port"+port);
			Socket socket = null;
			while(true){
				socket = server.accept();
				new Thread(new TimeServerHandler(socket)).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(server!=null){
				System.out.println("The time server close");
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				server =null;
			}
		}
		
	}

}
   