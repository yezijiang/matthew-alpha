/** 
 * Project Name:myPratice 
 * File Name:NoVisibility.java 
 * Package Name:com.yaoyaohao.multiply 
 * Date:2015-12-2上午11:22:19 
 * Copyright (c) 2015, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.multiply;

public class NoVisibility {
	private static boolean ready;
	private static int number;
	public static class ReaderThread extends Thread{

		@Override
		public void run() {
			while (!ready){
				Thread.yield();
				System.out.println(number);
			}
		}
		
	}
	public static void main(String args[]){
		new ReaderThread().start();
		System.out.println(ready);
		System.out.println(number);
		number =42;
		ready = true;
		
	}

}
  