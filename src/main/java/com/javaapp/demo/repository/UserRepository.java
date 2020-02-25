package com.javaapp.demo.repository;

import org.springframework.stereotype.Repository;


import com.javaapp.demo.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public List<User> findByUserName(String userName);
}
