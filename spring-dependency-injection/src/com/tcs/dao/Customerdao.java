package com.tcs.dao;

public class Customerdao 
{

	Datasource datasource;

	public Datasource getDatasource() {
		return datasource;
	}

	public void setDatasource(Datasource datasource) {
		this.datasource = datasource;
	}
	
	public void connect()
	{
		System.out.println("---- connecting to database ----");
		System.out.println("URL: "+datasource.getUrl());
		System.out.println("Username: "+datasource.getUsername());
		System.out.println("Password:"+datasource.getPassword());
	}
	
}
