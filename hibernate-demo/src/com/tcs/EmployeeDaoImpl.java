package com.tcs;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class EmployeeDaoImpl
{
	
	Scanner scan = new Scanner(System.in);
public int store(Employee employee) 
{
	int key = 0;
	SessionFactory factory = HibernateUtil.createSessionFactory();
	Session session = factory.openSession();
	Transaction transaction = session.beginTransaction();
	key = (int)session.save(employee);
	transaction.commit();
	session.close();
	factory.close();
	return key;
}

public Employee fetchEmployee(int empId)
{
	Employee employee =null;
	SessionFactory factory = HibernateUtil.createSessionFactory();
	Session session = factory.openSession();
	employee = session.get(Employee.class, empId);  // get() method initializes other properties of Employee automatically
	session.close();
	factory.close();
	return employee;
}

public List<Employee> fetchEmployees() {
	List<Employee> employees = null;
	SessionFactory factory = HibernateUtil.createSessionFactory();
	Session session = factory.openSession();
	// createQuery() is used to pass the HQL and get the collection of Employee
	Query<Employee> query = session.createQuery("select e from Employee e", Employee.class);
	employees = query.getResultList();
	session.close();
	factory.close();
	return employees;

}

public Employee DeleteEmployee(int empId)
{
	Employee employee=null;
	SessionFactory factory = HibernateUtil.createSessionFactory();
	Session session = factory.openSession();
	Transaction transaction = session.beginTransaction();
	employee = session.get(Employee.class, empId);  
	session.delete(employee);
	transaction.commit();
	session.close();
	factory.close();
	return employee;
	
	
}
public Employee UpdateEmployee(int empId)
{
	SessionFactory factory = HibernateUtil.createSessionFactory();
	Session session = factory.openSession();
	Transaction transaction = session.beginTransaction();
	Employee employee = session.get(Employee.class, empId);
	System.out.println("Enter updated salary");
	employee.setSalary(scan.nextDouble());
	session.saveOrUpdate(employee);
	transaction.commit();
	session.close();
	factory.close();
	return employee;
}
}
