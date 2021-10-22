package com.tcs.dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestDbNewApproach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context  = new ClassPathXmlApplicationContext("spring-beans.xml");
		Customerdao dao = (Customerdao)context.getBean("dao");
		dao.connect();
		((ClassPathXmlApplicationContext)context).close();
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
