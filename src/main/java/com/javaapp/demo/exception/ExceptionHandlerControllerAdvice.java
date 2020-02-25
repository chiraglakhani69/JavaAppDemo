package com.javaapp.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.javaapp.demo.dto.ErrorResponse;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(InvalidRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse badRequest(InvalidRequestException e) {
		return new ErrorResponse(400, e.getMessage());
	}
}
