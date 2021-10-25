package com.tcs.service;



import com.tcs.entity.Account;
import com.tcs.exceptions.AccountNotFoundExpection;
import com.tcs.exceptions.InsufficientBalanceException;

public interface AccountService 
{

	public Account store(Account account);
	public Account fetchAccountByAccountNumber(int accountnumber) throws AccountNotFoundExpection;
	public void transferbalance(int accountnumber,int toaccount,double amount) throws InsufficientBalanceException, AccountNotFoundExpection;
	public Account updatepassword(int accountnumber,String password) throws AccountNotFoundExpection;
	
	 
}
