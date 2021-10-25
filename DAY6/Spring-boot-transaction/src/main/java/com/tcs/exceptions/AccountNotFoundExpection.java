package com.tcs.exceptions;

@SuppressWarnings("serial")
public class AccountNotFoundExpection extends Exception
{
	AccountNotFoundExpection()
	{
		super();
	}
	public AccountNotFoundExpection (String message) {
		super(message);
	}

}
