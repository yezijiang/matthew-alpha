package com.matthew.dubbo.spi;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-12 11:19
 */
public class MysqlRepository implements IRepository {
	@Override
	public void save(String data) {
		System.out.println("mysql" + data + "repository");
	}
}
