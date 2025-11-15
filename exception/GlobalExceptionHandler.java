package com.qsp.hospital_management_system.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(exception=DoesNotExistException.class)
	public String handleDoesNotFound(DoesNotExistException doesNotExistException) {
		return doesNotExistException.getMessage();
	}
}
