package com.javaapp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaapp.demo.dto.RegisterRequest;
import com.javaapp.demo.dto.RegisterResponse;
import com.javaapp.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired	
	UserService registerService;
	
	@PostMapping("/register")
	public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
		return new RegisterResponse();
	}
}
