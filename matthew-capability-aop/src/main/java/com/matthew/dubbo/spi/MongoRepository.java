package com.matthew.dubbo.spi;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-12 11:20
 */
public class MongoRepository implements IRepository {
	@Override
	public void save(String data) {
		System.out.println("mongo" + data + "reposotory");
	}
}
