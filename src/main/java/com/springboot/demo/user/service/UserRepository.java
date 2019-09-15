package com.springboot.demo.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository  {
	
	@Autowired
	private UserRepositiryCache cache;

	@Cacheable("user")
	public User getUser(Integer id) {
		
		return cache.getUser(id);
	}
	public List<User> getUsers() {
				
		return cache.getUsers();
	}
	
	public void createUser(User u) {
		cache.saveUser(u);
	}
	
	public User deleteUser(Integer id) {
		return cache.deleteUser(id);
	}
	
	public User modifyUser(User user) {
		return cache.modifyUser(user);
	}
}
