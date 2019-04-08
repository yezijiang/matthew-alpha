package com.matthew.javabase.stream;

import lombok.Getter;
import lombok.Setter;


/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-25 17:25
 */
@Setter
@Getter
public class User {
	private Long id;
	private String phone;
	private String username;
	private String nickname;
	private Integer age;

	// 提供一个接收当前对象的构造函数
	private User(Builder builder) {
		this.id = builder.id;
		this.phone = builder.phone;
		this.username = builder.username;
		this.nickname = builder.nickname;
		this.age = builder.age;
	}
	// 静态内部类 Builder
	// User的创建完全依靠User.Builder，使用一种方法链的方式来创建
	public static class Builder {
		private Long id;
		private String phone;
		private String username;
		private String nickname;
		private Integer age;

		// Setter方法，方法名为属性名，方法返回Builder对象
		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder nickname(String nickname) {
			this.nickname = nickname;
			return this;
		}

		public Builder age(Integer age) {
			this.age = age;
			return this;
		}

		// build 方法
		public User build(){
			return new User(this);
		}
	}

}
