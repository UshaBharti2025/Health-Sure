//package com.java.jsf.recipient.util;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class Test {
//    public static void main(String[] args) {
//    	try {
//            // Load Hibernate config and mappings
//            SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//
//            // Try opening a session
//            Session session = factory.openSession();
//            System.out.println("✅ Hibernate connected successfully to database!");
//
//            session.close();
//            factory.close();
//        } catch (Exception e) {
//            System.out.println("❌ Hibernate failed to connect!");
//            e.printStackTrace();
//        }
//    }
// }
//    	
    	        
    	
//    	  try {
//              Configuration cfg = new Configuration().configure(); // will read hibernate.cfg.xml
//              SessionFactory sessionFactory = cfg.buildSessionFactory();
//              Session session = sessionFactory.openSession();
//              System.out.println("✅ Hibernate connected: " + session.isConnected());
//              session.close();
//          } catch (Exception e) {
//              System.out.println("❌ Failed to connect.");
//              e.printStackTrace();
//          }
    	
//    	SessionFactory sf=SessionHelper.getConnection();
//    	Session session=sf.openSession();
//    	System.out.println("connection is  : "+ session);
//   	
//        try {
//            // Load configuration from hibernate.cfg.xml
//            Configuration cfg = new Configuration().configure(); // default: hibernate.cfg.xml
//            SessionFactory sessionFactory = cfg.buildSessionFactory();
//
//            // Open a session
//            Session session = sessionFactory.openSession();
//
//            // Check connection
//            if (session.isConnected()) {
//                System.out.println("✅ Hibernate successfully connected to the database.");
//            } else {
//                System.out.println("❌ Hibernate failed to connect to the database.");
//            }
//
//            // Close session
//            session.close();
//            sessionFactory.close();
//        } catch (Exception e) {
//            System.out.println("❌ Exception occurred while connecting to database:");
//            e.printStackTrace();
//        }
    

