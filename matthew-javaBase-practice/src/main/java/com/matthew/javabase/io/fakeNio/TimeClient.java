/** 
 * Project Name:mypractice 
 * File Name:TimeClient.java 
 * Package Name:com.yaoyaohao.io 
 * Date:2016-1-19下午4:14:09 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.io.fakeNio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @ClassName:  TimeClient   
 * @Description:同步阻塞式I/O创建的timeClient
 * @author maxing
 * @date:   2016-1-19 下午4:14:13   
 *
 */
public class TimeClient {
	public static void main(String args[]){
		int port = 8080;
		if(args!=null&&args.length>0){
			try{
				port = Integer.parseInt(args[0]);
			}catch(NumberFormatException e){
				//采用默认值8080
			}
		}
		Socket socket=null;
		PrintWriter out = null;
		BufferedReader in =null;
		try {
			socket = new Socket("172.16.9.12",port);
			out = new PrintWriter(socket.getOutputStream(),true);
			in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String queryOrder ="QUERY TIME ORDER";
			out.println(queryOrder);
			String resp = in.readLine();
			System.out.println("Now is :"+resp);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		}
		
	}
}
  