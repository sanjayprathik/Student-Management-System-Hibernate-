package com.studentpackage;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory =buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try{
			SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
		}catch(Exception e) {
			System.out.println("SESSION FAILED");
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
