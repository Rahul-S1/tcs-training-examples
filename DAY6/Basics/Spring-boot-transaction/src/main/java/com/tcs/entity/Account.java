package com.tcs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account 
{
	@Column(name = "accountnumber")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountnumber;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "dateofbirth")
	private String dateofbirth;
	@Column(name = "balance")
	private double balance;
	
	
	public Account(int accountnumber, String username, String password, String dateofbirth, double balance) {
		super();
		this.accountnumber = accountnumber;
		this.username = username;
		this.password = password;
		this.dateofbirth = dateofbirth;
		this.balance = balance;
	}
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnunber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	
	
}
