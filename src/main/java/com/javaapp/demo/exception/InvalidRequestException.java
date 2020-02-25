package com.javaapp.demo.exception;

public class InvalidRequestException extends RuntimeException {

	private static final long serialVersionUID = -8476327201374385182L;

	public InvalidRequestException(String message) {
		super(message);
	}
}
