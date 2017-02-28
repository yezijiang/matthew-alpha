/** 
 * Project Name:mypractice 
 * File Name:TimeServerHandler.java 
 * Package Name:com.yaoyaohao.io 
 * Date:2016-1-14下午2:58:15 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable{
	
	public Socket socket;
	public TimeServerHandler(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		BufferedReader in =null;
		PrintWriter out =null;
		try {
			in  = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(),true);
			String body = null;
			String returnMessage=null;
			while (true){
				body = in.readLine();
				if(body == null)
					break;
				System.out.println("The time server receive order:"+body);
				returnMessage = "QUERY TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"WROGN ORDER";
				out.println(returnMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			if(out != null){
				out.close();
				out =null;
			}
			
			if(this.socket!=null){
				try {
					this.socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
  