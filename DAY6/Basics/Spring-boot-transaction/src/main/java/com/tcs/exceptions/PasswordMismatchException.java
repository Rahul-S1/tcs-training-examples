package com.tcs.exceptions;

@SuppressWarnings("serial")
public class PasswordMismatchException extends Exception {
	
	PasswordMismatchException() {
		super();
	}
	public PasswordMismatchException(String message)
	{
		super(message);
	}	
	
}
