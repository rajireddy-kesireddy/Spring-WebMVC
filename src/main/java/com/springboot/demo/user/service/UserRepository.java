package com.springboot.demo.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository  {

	public User getUser(int id) {
		
		User u = new User();
		u.setId(id);
		u.setName("Test");
		u.setAge(30);
		u.setEmail("abc@xyz.com");
		u.setPhone(9180234567L);
		u.setSex("M");
		return u;
	}
	
	
	public List<User> getUsers() {
		
		List<User> users = new ArrayList<>();
		users.add(createUser(1, "name1", 20));
		users.add(createUser(2, "name2", 24));
		users.add(createUser(3, "name3", 25));
		users.add(createUser(4, "name4", 26));
		
		return users;
	}
	
	private User createUser(int id,String name,int age) {
		
		User u = new User();
		u.setId(id);
		u.setName(name);
		u.setAge(age);
		u.setEmail("abc@xyz.com");
		u.setPhone(9180234567L);
		u.setSex("M");
		return u;
	}
}
