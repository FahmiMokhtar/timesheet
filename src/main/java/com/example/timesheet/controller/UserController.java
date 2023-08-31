package com.example.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.timesheet.exception.ResourceNotFoundException;
import com.example.timesheet.model.User;
import com.example.timesheet.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public Iterable findAll() {
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value = "id") Long userId) {
    	
		User user = userService.getUser(userId);
		if (user != null) return user;
		else throw(new ResourceNotFoundException("User", "id", userId));
	}
	
}
