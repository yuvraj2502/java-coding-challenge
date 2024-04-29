package com.exception;

public class PolicyNotFoundException extends Exception {

	private static final long serialVersionUID = -685220413016687038L;
	private String message;

	public PolicyNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
