package com.qsp.hospital_management_system.exception;

public class DoesNotExistException extends RuntimeException{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DoesNotExistException(String message) {
		super();
		this.message = message;
	}
	
}
