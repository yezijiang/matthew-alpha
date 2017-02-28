/** 
 * Project Name:myPratice 
 * File Name:TestDynamicDataSourceProcessor.java 
 * Package Name:com.yaoyaohao.lang 
 * Date:2015-11-20下午4:56:03 
 * Copyright (c) 2015, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.lang;

import java.lang.reflect.Field;

public class TestDynamicDataSourceProcessor {
	public static void main(String args[]){
		Class<?> clazz = Person.class;
		for(Field field : clazz.getDeclaredFields()) {
			if(String.class.isAssignableFrom(field.getType())) {
				System.out.println(field.getType());
			}
		}
		
		String batchNos ="";
		String[] batchNoArray = batchNos.split(",");
		System.out.println(batchNoArray[0]);
	}

}
  