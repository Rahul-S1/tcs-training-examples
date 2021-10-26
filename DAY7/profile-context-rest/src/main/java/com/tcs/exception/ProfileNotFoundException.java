package com.tcs.exception;

@SuppressWarnings("serial")
public class ProfileNotFoundException extends Exception
{
	ProfileNotFoundException()
	{
		super();
	}
	public ProfileNotFoundException(String message)
	{
		super(message);
	}

}
