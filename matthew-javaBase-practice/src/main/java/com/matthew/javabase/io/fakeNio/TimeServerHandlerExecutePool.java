/** 
 * Project Name:mypractice 
 * File Name:TimeServerHandlerExecutePool.java 
 * Package Name:com.yaoyaohao.io.fakeNio 
 * Date:2016-1-19下午5:13:08 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.io.fakeNio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimeServerHandlerExecutePool {
	private ExecutorService executor;
	public TimeServerHandlerExecutePool(int maxPoolSize,int queueSize){
		executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),maxPoolSize,120L,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queueSize));
	}
	public void execute(Runnable task){
		executor.execute(task);
	}
}
  