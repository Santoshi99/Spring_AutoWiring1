package com.infy.exception;

public class InfyDASystemException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * This is a constructor, receives a string and passes it to Exception class for
	 * setting it as an exception message.
	 *
	 * @param exception message
	 */
	public InfyDASystemException(String message) {

		super(message);
	}
}
