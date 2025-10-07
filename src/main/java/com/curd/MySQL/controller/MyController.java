package com.curd.MySQL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.curd.MySQL.entity.User;
import com.curd.MySQL.service.MyService;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class MyController {

	@Autowired
	private MyService myService;
	
	@PostMapping("/post")
	public User createUser(@RequestBody User user) {
		return myService.createUser(user);
	}
	
	@GetMapping("/get")
	public List<User> getAllUser(){
		return myService.getAllUser();
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return myService.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		return myService.deleteUser(id);
	}
}
