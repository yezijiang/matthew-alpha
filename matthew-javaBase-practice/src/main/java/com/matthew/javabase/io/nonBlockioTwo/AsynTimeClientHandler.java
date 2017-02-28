/** 
 * Project Name:mypractice 
 * File Name:AsynTimeClienthandler.java 
 * Package Name:com.yaoyaohao.io.nonBlockioTwo 
 * Date:2016-1-22下午3:37:10 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.io.nonBlockioTwo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class AsynTimeClientHandler implements CompletionHandler<Void,AsynTimeClientHandler>,Runnable{
	private AsynchronousSocketChannel client;
	private String host;
	private int port;
	private CountDownLatch latch;
	public AsynTimeClientHandler(String host,int port){//构造方法，首先创建一个AsynchronousSocketChannel
		this.host = host;
		this.port = port;
		try {
			client = AsynchronousSocketChannel.open();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		latch = new CountDownLatch(1);//创建CountDownLatch进行等待，防止异步操作没有执行完成线程就退出。
		client.connect(new InetSocketAddress(host,port),this,this);
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void completed(Void result, AsynTimeClientHandler attachment) {
		byte[] req = "QUERY TIME ORDER".getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
		writeBuffer.put(req);
		writeBuffer.flip();
		client.write(writeBuffer,writeBuffer,new CompletionHandler<Integer,ByteBuffer>(){

			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				if(attachment.hasRemaining()){
					client.write(attachment,attachment,this);
				}else{
					ByteBuffer readBuffer = ByteBuffer.allocate(1204);
					client.read(readBuffer,readBuffer,new CompletionHandler<Integer,ByteBuffer>(){

						@Override
						public void completed(Integer result,ByteBuffer buffer) {
							buffer.flip();
							byte[] readBytes = new byte[buffer.remaining()];
							buffer.get(readBytes);
							String body;
							try {
								body = new String(readBytes,"utf-8");
								System.out.println("now is"+body);
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
							
						}

						@Override
						public void failed(Throwable exc, ByteBuffer buffer) {
							try {
								client.close();
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
					client.close();
					latch.countDown();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
	}
	@Override
	public void failed(Throwable exc, AsynTimeClientHandler attachment) {
		exc.printStackTrace();
		try {
			client.close();
			latch.countDown();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
  