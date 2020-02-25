package com.javaapp.demo.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaapp.demo.entity.User;
import com.javaapp.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public String save(User user) {
		userRepository.save(user);
		logger.info("User created with userId {}", user.getUserId());
		return user.getUserId();
	}

	@Override
	public boolean isExist(String userName) {
		List<User> users = userRepository.findByUserName(userName);
		return !users.isEmpty();
	}
}
