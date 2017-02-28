/** 
 * Project Name:mypractice 
 * File Name:AsnyTimeServerHandler.java 
 * Package Name:com.yaoyaohao.io.nonBlockioTwo 
 * Date:2016-1-22下午1:56:13 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.io.nonBlockioTwo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsynTimeServerHandler implements Runnable{
	private int port;
	
	CountDownLatch latch;
	AsynchronousServerSocketChannel asynchronousServerSocketChannel;
	
	public AsynTimeServerHandler(int port){
		this.port = port;
		try {
			asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();//创建一个异步的服务端通道Asynchronous
			asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
			System.out.println("The time server is start in port :"+port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void run() {
		latch = new CountDownLatch(1);//它的作用是在完成一组正在执行的操作之前，允许当前线程一致阻塞。
		doAccept();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void doAccept(){
		asynchronousServerSocketChannel.accept(this,new AcceptCompletionHandler());//用于接受客户端的连接，可以传递一个CompletionHandler<AsynchronousSockeetChannel,?super A>类型的handler实例接受accept
		
	}

}
  