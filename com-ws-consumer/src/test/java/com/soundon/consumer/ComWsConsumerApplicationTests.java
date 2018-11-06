package com.soundon.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sample.ws.service.Greeting;
import sample.ws.service.Hello;
import sample.ws.service.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComWsConsumerApplicationTests {

	private Hello hello;
	
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void m1() {
		
		
		
		Person p = new Person();
		
		p.setFirstName("张");
		p.setLastName("三");
		
		Greeting g =this.hello.sayHello(p);
		
		
		System.out.println("---------------------------------------");
		
		System.out.println(g.getGreeting());
		
		System.out.println("---------------------------------------");
		
		
		
	}


	public Hello getHello() {
		return hello;
	}


	@Autowired
	@Required
	public void setHello(@Qualifier("helloProxy") Hello hello) {
		this.hello = hello;
	}
	
	
	

}
