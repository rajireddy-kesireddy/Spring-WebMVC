package com.springboot.demo.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/version")
	public ResponseEntity<String> getVersion(){
		return new ResponseEntity<String>("build version:0.0.1-SNAPSHOT",HttpStatus.OK);
	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getUsers(){
		List<User> users = userRepository.getUsers();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@GetMapping(value = "/user/{user_id}")
	public ResponseEntity<User> getUser(
			@PathVariable(name = "user_id", required=true, value="user_id" )int id){
		
		return new ResponseEntity<User>(userRepository.getUser(id),HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/user")
	public ResponseEntity<User> create(			
			@RequestBody(required = true) User user){
		userRepository.createUser(user);
		return new ResponseEntity<User>(userRepository.getUser(user.getId()),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/user")
	public ResponseEntity<User> update(			
			@RequestBody(required = true) User user){
		user = userRepository.modifyUser(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/user/{user_id}")
	public ResponseEntity<User> delete(
			@PathVariable(name = "user_id", required=true, value="user_id" )int id){
		User user = userRepository.deleteUser(id);
		return new ResponseEntity<User>(user,HttpStatus.NO_CONTENT);
	}
	
	

}
