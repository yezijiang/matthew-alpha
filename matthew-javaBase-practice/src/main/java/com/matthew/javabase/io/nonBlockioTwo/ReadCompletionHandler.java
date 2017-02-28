/** 
 * Project Name:mypractice 
 * File Name:ReadCompletionHandler.java 
 * Package Name:com.yaoyaohao.io.nonBlockioTwo 
 * Date:2016-1-22下午2:53:13 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.io.nonBlockioTwo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

public class ReadCompletionHandler implements CompletionHandler<Integer,ByteBuffer>{
	private AsynchronousSocketChannel channel;
	public ReadCompletionHandler(AsynchronousSocketChannel channel){
		if(this.channel == null){
			this.channel = channel;
		}
	}

	@Override
	public void completed(Integer result, ByteBuffer attachment) {
		attachment.flip();//首先对attachment进行flip()操作，
		byte[] body =  new byte[attachment.remaining()];
		attachment.get(body);
		
		try {
			String req = new String(body,"utf-8");
			System.out.println("The time server receive order:"+req);
			String returnMsg = "QUERY TIME ORDER".equalsIgnoreCase(req)?new Date().toString():"The order that you send is not recognized";
			doWrite(returnMsg);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

	private void doWrite(String returnMsg){
		if(returnMsg!=null&&returnMsg.trim().length()>0){
			byte[] msgByte= returnMsg.getBytes();
			ByteBuffer writeBuffer  = ByteBuffer.allocate(msgByte.length);
			writeBuffer.put(msgByte);
			writeBuffer.flip();
			channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer,ByteBuffer>(){

				@Override
				public void completed(Integer result, ByteBuffer attachment) {
					//如果没发送完成，就继续发送。
					if(attachment.hasRemaining()){
						channel.write(attachment,attachment,this);
					}
					
				}

				@Override
				public void failed(Throwable exc, ByteBuffer attachment) {
					try {
						channel.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			});
		}
	}
	@Override
	public void failed(Throwable exc, ByteBuffer attachment) {
		try {
			this.channel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
  