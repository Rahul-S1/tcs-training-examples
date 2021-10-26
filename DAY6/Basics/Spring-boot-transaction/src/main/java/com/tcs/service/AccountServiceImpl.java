package com.tcs.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.dao.AccountRepository;
import com.tcs.entity.Account;
import com.tcs.exceptions.AccountNotFoundExpection;
import com.tcs.exceptions.InsufficientBalanceException;
import com.tcs.exceptions.PasswordMismatchException;




@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository dao;

	@Override
	@Transactional
	public Account store(Account account) {
		return dao.save(account);
	}

	@Override
	public Account fetchAccountByAccountNumber(int accountnumber)throws AccountNotFoundExpection
	{
		Account ac = dao.findById(accountnumber).orElse(null);
		if(ac==null)
		{
			throw new AccountNotFoundExpection("Account with an Account no "+accountnumber+" is not found");
		}
		return ac;
		
	}
	@Override
	public Account fetchAccountByAccountNumberAndPass(int accountnumber,String pass) throws AccountNotFoundExpection , PasswordMismatchException
	{
		
		Account ac = dao.findById(accountnumber).orElse(null);
		if(ac==null)
		{
			throw new AccountNotFoundExpection("Account with an Account no "+accountnumber+" is not found");
		}
		else if(!ac.getPassword().equals(pass))
		{
			throw new AccountNotFoundExpection("Password mismatch");
		}
		return ac;
	}

	@Override
	@Transactional
	public void transferbalance(int accountnumber,int toaccount,double amount) throws InsufficientBalanceException,AccountNotFoundExpection
	{
		Account ac = fetchAccountByAccountNumber(accountnumber);
		
		Account toac= fetchAccountByAccountNumber(toaccount);
		
		if(ac.getBalance()<amount)
		{
			throw new AccountNotFoundExpection("Account with an Account no "+accountnumber+"has not sufficient balance");
		}
		double b1 = ac.getBalance();
		double b2 = toac.getBalance();
		
			ac.setBalance(b1-amount);
			toac.setBalance(b2+amount);
		
		
	}

	@Override
	@Transactional
	public Account updatepassword(int accountnumber, String password) throws AccountNotFoundExpection {
		Account ac = fetchAccountByAccountNumber(accountnumber);
		ac.setPassword(password);
		return ac;
		
	}


	

	
	}

	

