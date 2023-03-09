package com.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.User;
import com.app.service.UserService;

@SpringBootTest
class FincontrolApplicationTests {

	@Autowired
	private UserService service;
	@Test
	void contextLoads() {
	}

	
	@Test
	public void insertdata()
	{
	User user=new User("Avadhoot", "Pawar", "Nashik", "ava@gmail.com", "123", "123");	
	service.addUser(user);
	}
}
