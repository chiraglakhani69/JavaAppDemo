package com.javaapp.demo.dto;

public class RegisterResponse {

	private String userId;
	
	public RegisterResponse(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
