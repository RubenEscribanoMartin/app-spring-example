package com.app.spring.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.spring.example.repository.UserRepository;
/*
 * @Controller
 * We need repository (extending by CRUD) 
 * Creating the constructor with the repository
 * As we want to show/get the users then;
 * Creating a simple String method with model param
 * Assigning @RequestMapping
 * Returning a "userlist" which must have the same name
 * as the html template
 */
@Controller
public class UserController {
	
	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@RequestMapping("/users")
	public String getUsers(Model model) {
		
		model.addAttribute("users", userRepository.findAll());
		
		return "userList";//"userList" > template HTML
	}
	
	

}
