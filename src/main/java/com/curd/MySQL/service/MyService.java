package com.curd.MySQL.service;

import com.curd.MySQL.entity.*;
import com.curd.MySQL.repository.MyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Autowired
	private MyRepository myRepository;
	
	public User createUser(User user) {
		return myRepository.save(user);
	}
	
	public List<User> getAllUser(){
		return myRepository.findAll();
	}
	
	public User getUserById(Long id) {
		return myRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	}
	
	public User updateUser(Long id, User updatedUser) {
		User emp = getUserById(id);
		emp.setName(updatedUser.getName());
		emp.setEmail(updatedUser.getEmail());
		emp.setDepartment(updatedUser.getDepartment());
		return myRepository.save(emp);
	}
	
	public String deleteUser(Long id) {
		myRepository.deleteById(id);
		return "User deleted successfully";
	}
}
