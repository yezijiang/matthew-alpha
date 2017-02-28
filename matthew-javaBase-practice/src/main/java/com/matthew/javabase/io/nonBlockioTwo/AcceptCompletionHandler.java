/** 
 * Project Name:mypractice 
 * File Name:AcceptCompletionHandler.java 
 * Package Name:com.yaoyaohao.io.nonBlockioTwo 
 * Date:2016-1-22下午2:09:21 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.io.nonBlockioTwo;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel,AsynTimeServerHandler>{
	@Override
	public void completed(AsynchronousSocketChannel result, AsynTimeServerHandler attachment) {
		attachment.asynchronousServerSocketChannel.accept(attachment,this);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		result.read(buffer,buffer,new ReadCompletionHandler(result));
	}

	@Override
	public void failed(Throwable exc, AsynTimeServerHandler attachment) {
		exc.printStackTrace();
		attachment.latch.countDown();
		
	}

}
  