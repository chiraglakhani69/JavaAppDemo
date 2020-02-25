package com.javaapp.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.javaapp.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository registerRepository;
}
