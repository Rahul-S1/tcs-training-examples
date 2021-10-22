package com.tcs.dao;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tcs.beans.Employee;
@Repository
public class EmployeeDaoImpV1 implements EmployeeDao
{
	Scanner scan=new Scanner(System.in);
	@Autowired
	private HibernateTemplate template;
	
	@Override
	public int save(Employee employee) {
		int key = (int)template.save(employee);

		return key;
	}

	@Override
	public void updateEmployee(Employee employee, int id) {
	
		template.update(employee);

	}

	@Override
	public Employee fetchEmployee(int id) {
		return template.get(Employee.class, id);
		
	}

	@Override
	public List<Employee> fetchEmployees() {
		return template.loadAll(Employee.class);
				
		
	}

}
