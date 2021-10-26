package com.tcs.exception;

@SuppressWarnings("serial")
public class ContactNotFoundException extends Exception 
{
	ContactNotFoundException()
	{
		super();
	}
	public ContactNotFoundException (String message) {
		super(message);
	}
}
