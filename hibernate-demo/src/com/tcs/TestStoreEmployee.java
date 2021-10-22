package com.tcs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestStoreEmployee {
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.createSessionFactory();
		
		Session session = factory.openSession();
		
		Employee employee1 = new Employee();
		employee1.setName("john");
		employee1.setSalary(60000);
		
		Employee employee2 = new Employee();
		employee2.setName("bravo");
		employee2.setSalary(90000);
		
		Transaction transaction = session.beginTransaction();
		
		session.save(employee1); 
		session.save(employee2);
		
		transaction.commit();
		
		
		session.close();
		factory.close();
		System.out.println("------ Saved Successfully -------");
	}

}
