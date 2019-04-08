package com.matthew.javabase.lang.reflect;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-15 11:34
 */
public class InvokeTest {
	@Test
	public void buildInvokeChain(){
		Car car = new Car("","",11);
		IHelloService iHelloService = new IHelloService() {
			@Override
			public void sayHello(String name) {
				System.out.println(car.toString());
			}
		};
		iHelloService.sayHello(car.toString());
	}

}
