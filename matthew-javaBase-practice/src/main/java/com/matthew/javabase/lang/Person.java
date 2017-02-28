/** 
 * Project Name:myPratice 
 * File Name:Person.java 
 * Package Name:com.yaoyaohao.lang 
 * Date:2015-11-20下午4:56:36 
 * Copyright (c) 2015, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.lang;

public class Person {
	private String name="jack";
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	//定义一个改变对象属性的方法
	public static void changeName(Person p) {
		p.name = "Rose";
	}

	public static void main(String[] args) {
		//定义一个Person对象，person是这个对象的引用
		Person person = new Person();
		//先显示这个对象的name属性
		System.out.println(person.name);
		//调用changeName(Person p)方法
		changeName(person);
		//再显示这个对象的name属性，看是否发生了变化
		System.out.println(person.name);
	}
}