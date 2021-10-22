package com.tcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.dao.CustomerDao;

@Service
public class CustomerServiceImplV1 implements CustomerService
{
	@Autowired
	private CustomerDao dao;

	@Override
	public void save() {
		// TODO Auto-generated method stub
		dao.store();
		System.out.println("save() inside CustomerServiceImplV1");
		
	}

	@Override
	public void update() {
		
		dao.update();
		System.out.println("update() inside CustomerServiceImplV1");
	}

}
