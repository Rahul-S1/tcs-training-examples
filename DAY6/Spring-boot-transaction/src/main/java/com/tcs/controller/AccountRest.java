package com.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.entity.Account;
import com.tcs.entity.CustomResponce;
import com.tcs.exceptions.AccountNotFoundExpection;
import com.tcs.exceptions.InsufficientBalanceException;
import com.tcs.service.AccountService;

@RestController
@RequestMapping("account")
public class AccountRest 
{
	@Autowired
	private AccountService service;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> openAccount(@RequestBody Account account){
		ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.CREATED).body(service.store(account));
		return response;
	}
	
	@GetMapping(path = "{ac}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findAccount(@PathVariable("ac") int accountnumber)
	{
		ResponseEntity<Object> response =null;
		try {
			Account account = service.fetchAccountByAccountNumber(accountnumber);
			response = ResponseEntity.status(HttpStatus.OK).body(account);
		}catch(AccountNotFoundExpection e)
		{
			CustomResponce data = new CustomResponce();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
	
	@PutMapping(path = "{ac1}/{ac2}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> transfermoney(@PathVariable("ac1") int ac1, @PathVariable("ac2") int ac2,@PathVariable("amount") double amount )
	{
		ResponseEntity<Object> response = null;
		try {
			service.transferbalance(ac1,ac2,amount);
			CustomResponce data = new CustomResponce();
			data.setMsg("Money Transfer Successfully");
			response = ResponseEntity.status(HttpStatus.OK).body(data);
		}catch(AccountNotFoundExpection e) {
			CustomResponce data = new CustomResponce();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}catch(InsufficientBalanceException e1) {
			CustomResponce data = new CustomResponce();
			data.setMsg(e1.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
	
	@PutMapping(path = "{ac}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updatepassword(@PathVariable("ac") int ac, @PathVariable("password") String password)
	{
		ResponseEntity<Object> response = null;
		try {
			service.updatepassword(ac,password);
			CustomResponce data = new CustomResponce();
			data.setMsg("Password Changed Successfully");
			response = ResponseEntity.status(HttpStatus.OK).body(data);
		}
		catch(AccountNotFoundExpection e) {
			CustomResponce data = new CustomResponce();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
}
