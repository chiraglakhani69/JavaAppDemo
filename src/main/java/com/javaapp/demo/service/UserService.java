package com.javaapp.demo.service;

import com.javaapp.demo.entity.User;

public interface UserService {

	String save(User user);
	
	boolean isExist(String userName);
}
