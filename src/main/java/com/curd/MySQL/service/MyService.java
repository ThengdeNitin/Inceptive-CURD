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
	
	public User createUser(User employee) {
		return myRepository.save(employee);
	}
	
	public List<User> getAllUser(){
		return myRepository.findAll();
	}
	
	public User getUserId(Long id) {
		return myRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	}
	
	public User updateUser(Long id, User updatedEmployee) {
		User emp = getUserId(id);
		emp.setName(updatedEmployee.getName());
		emp.setEmail(updatedEmployee.getEmail());
		emp.setDepartment(updatedEmployee.getDepartment());
		return myRepository.save(emp);
	}
	
	public String deleteUser(Long id) {
		myRepository.deleteById(id);
		return "User deleted successfully";
	}
}
