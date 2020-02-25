package com.javaapp.demo.repository;

import org.springframework.stereotype.Repository;

import com.javaapp.demo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
