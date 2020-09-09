package com.dhruba.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhruba.microservices.model.User;

@RestController
public class UserController {
	
	@GetMapping("/user")
	public User getUser(
			@RequestParam(value="firstname" , defaultValue="Dhruba") String firstName,
			@RequestParam(value="lastname" , defaultValue="Nag") String lastName,
			@RequestParam(value="age" , defaultValue="20") int age
			) {
		User user = new User();
		user.setFirstname(firstName);
		user.setLastname(lastName);
		user.setAge(age);
		
		return user;
	}
	
	@PostMapping("/user")
	public User addUser(User user) {
		
		System.out.println(user.toString());
		return user;
		
	}
}
