package com.springboot.demo.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositiryCache {
	
	private Map<Integer,User> userCache;
	
	public UserRepositiryCache() {
		userCache =  new ConcurrentHashMap<Integer, User>();
	}
	
	public void saveUser(User user) {
		userCache.computeIfAbsent(user.getId(), new Function<Integer, User>() {

			@Override
			public User apply(Integer userId) {				
				return user;
			}
		});
	}
	
	public User getUser(Integer id) {
		return userCache.get(id);
	}
	
	public List<User> getUsers(){
		List<User> users = new ArrayList<User>();
		Set<Integer> keys = userCache.keySet();
		keys.forEach(key->{
			users.add(userCache.get(key));});
		return users;		
	}
	
	public User deleteUser(Integer userId) {
		return userCache.remove(userId);
	}
	
	public User modifyUser(User user) {
		User u = userCache.get(user.getId());
		if(user.getEmail()!= null) {
			u.setEmail(user.getEmail());
		}
		if(user.getPhone() != null) {
			u.setPhone(user.getPhone());
		}
		if(!u.getName().equals(user.getName())) {
			throw new RuntimeException("Not allowed to change Name");
		}
		if(user.getSex() != null && u.getSex().equals(user.getSex())) {
			throw new RuntimeException("Not allowed to change Sex");
		}
		if(user.getAge() != null) {
			u.setAge(user.getAge());
		}
		return u;
	}

}
