package com.java.jsf.recipient.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class SessionHelper {
	
//	
//	public static SessionFactory getConnection() {
//		return new AnnotationConfiguration().configure().buildSessionFactory();
//	}

    private static final SessionFactory sessionFactory;
 
    static {
        try {
        	sessionFactory = new  AnnotationConfiguration().configure().buildSessionFactory();
//            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

//	public static Session getConnection() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}