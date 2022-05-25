package com.cognizant.exception;

/**
 * Class for handling UserNotFoundException
 */
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String msg) {
		super(msg);
	}
	private static final long serialVersionUID = 1L;

}
