package com.tcs;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
	public static SessionFactory createSessionFactory()
	{
		Configuration cfg = new Configuration().configure(); 
	
		SessionFactory factory = cfg.buildSessionFactory();
		return factory;
	}
}
