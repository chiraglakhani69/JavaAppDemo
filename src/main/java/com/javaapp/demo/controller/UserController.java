package com.javaapp.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaapp.demo.dto.RegisterRequest;
import com.javaapp.demo.dto.RegisterResponse;
import com.javaapp.demo.entity.User;
import com.javaapp.demo.exception.InvalidRequestException;
import com.javaapp.demo.service.UserService;
import com.javaapp.demo.util.ValidationUtil;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping("/register")
	public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {

		logger.info("User registration request received for user {}", registerRequest.getUserName());

		if (userService.isExist(registerRequest.getUserName())) {
			logger.error("Invalid request. Invalid user name {}", registerRequest.getUserName());
			throw new InvalidRequestException("User already exist");
		}

		if (!ValidationUtil.isValidEmail(registerRequest.getEmail())) {
			logger.error("Invalid request. Invalid email address {} for user {}", registerRequest.getEmail(),
					registerRequest.getUserName());
			throw new InvalidRequestException("Invalid email address");
		}

		if (!ValidationUtil.isValidPhoneNumner(registerRequest.getPhoneNumber())) {
			logger.error("Invalid request. Invalid phone number {} for user {}", registerRequest.getPhoneNumber(),
					registerRequest.getUserName());
			throw new InvalidRequestException("Invalid phone number");
		}

		if (!ValidationUtil.isValidPIN(registerRequest.getPin())) {
			logger.error("Invalid request. Invalid PIN number {} for user {}", registerRequest.getPin(),
					registerRequest.getUserName());
			throw new InvalidRequestException("Invalid PIN number");
		}

		String userId = userService.save(new User(registerRequest));

		logger.info("User registration request completed for user: " + registerRequest.getUserName());

		return new RegisterResponse(userId);
	}
}
