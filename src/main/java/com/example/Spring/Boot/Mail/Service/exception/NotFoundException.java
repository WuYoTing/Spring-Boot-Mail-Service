package com.example.Spring.Boot.Mail.Service.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2294054198084347502L;

	public NotFoundException(String message) {
		super(message);
	}
}
