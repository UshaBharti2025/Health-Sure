package com.java.jsf.recipient.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.java.jsf.recipient.model.Recipient;
import com.java.jsf.recipient.util.SessionHelper;

public class RecipientDaoImpl implements RecipientDao {
	
//====ref variable to get the session objects for connecting with db====
	SessionFactory sf;
	
//=====variable to open a single unit of work to interact with db===
	Session session;

	
	
//====method to fetch details through hid string type 
	@Override
	public Recipient searchByHid(String hId) {
	    System.out.println("DAO - Searching for HID: " + hId);
	    
	    sf = SessionHelper.getSessionFactory();
	    session = sf.openSession();
	    
	    try {
	        Query query = session.getNamedQuery("searchByHid");
	        query.setParameter("hId", hId);
	        Recipient recipient = (Recipient) query.uniqueResult();
	        
	        System.out.println("DAO - Found recipient: " + recipient);
	        return recipient;
	    } finally {
	        session.close();
	    }
	}

	
	


	
//----method to fetch details through search field as firstname---- 
//----search mode--------startswith feature----
	@Override
	public List<Recipient> searchByFirstNameStartsWith(String firstName) {
	    sf = SessionHelper.getSessionFactory();
	    session = sf.openSession();
	    try {
	        Query query = session.createQuery("from Recipient where lower(firstName) like :name");
	        query.setParameter("name", firstName.toLowerCase() + "%");
	        return query.list();
	    } finally {
	        session.close();
	    }
	}

	
	
//----method to fetch details through search field as firstname---- 
//----search mode--------contains feature----
	@Override
	public List<Recipient> searchByFirstNameContains(String firstName) {
	    sf = SessionHelper.getSessionFactory();
	    session = sf.openSession();
	    try {
	        Query query = session.createQuery("from Recipient where lower(firstName) like :name");
	        query.setParameter("name", "%" + firstName.toLowerCase() + "%");
	        return query.list();
	    } finally {
	        session.close();
	    }
	}

	
	

//----method to fetch details through search field as mobile---- 
	@Override
	public List<Recipient> searchByMobile(String mobile) {
	    if (mobile == null || mobile.trim().isEmpty()) {
	        return new ArrayList<>();
	    }

	    sf = SessionHelper.getSessionFactory();
	    session = sf.openSession();

	    try {
	        Query query = session.getNamedQuery("searchByMobile");
	        query.setParameter("mobile", "%" + mobile + "%");
	        return query.list();
	    } finally {
	        session.close();  // ✅ always close the session
	    }
	}




	@Override
	public List<Recipient> searchByCreatedAt(String createdAt) {
	    sf = SessionHelper.getSessionFactory();
	    session = sf.openSession();
	    try {
	        Query query = session.getNamedQuery("searchByCreatedAt");
	        query.setParameter("createdAt", "%" + createdAt + "%");
	        return query.list();
	    } finally {
	        session.close();  // 
	    }
	}
	
	

	 public List<Recipient> searchByCreatedAtRange(String fromDate, String toDate) {
	        Session session = SessionHelper.getSessionFactory().openSession();
	        Transaction tx = null;
	        List<Recipient> list = new ArrayList<>();
	        try {
	            tx = session.beginTransaction();
	            Query query = session.createQuery("FROM Recipient WHERE createdAt BETWEEN :fromDate AND :toDate");
	            query.setParameter("fromDate", java.sql.Date.valueOf(fromDate));
	            query.setParameter("toDate", java.sql.Date.valueOf(toDate));
	            list = query.list();
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) tx.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return list;
	    }


//----Show method to fetch the details of all recipient in the form of list---- 
	@Override
	public List<Recipient> showAllRecipients() {
	    sf = SessionHelper.getSessionFactory();
	    session = sf.openSession();
	    try {
	        Query query = session.getNamedQuery("showAllRecipients");
	        List<Recipient> recipientList = query.list();
	        return recipientList;
	    } finally {
	        session.close();  //Always close the session for any data leaks
	    }
	}


	
//UPDATE mehtod to check if all the details are valid and update after changes----
    @Override
    public boolean updateRecipient(Recipient recipient) {
        sf = SessionHelper.getSessionFactory();
        session = sf.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Recipient existing = (Recipient) session.get(Recipient.class, recipient.gethId());

            if (existing == null) return false; // Not found

            existing.setFirstName(recipient.getFirstName());
            existing.setLastName(recipient.getLastName());
            existing.setMobile(recipient.getMobile());
            existing.setEmail(recipient.getEmail());

            session.update(existing);
            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;

        } finally {
            session.close();
        }
    }
    
   
    
//----for hyperlink to fetch all the data in context with that hid----
    @Override
    public Recipient getRecipientByhId(String hId) {
        sf = SessionHelper.getSessionFactory();
        session = sf.openSession();

        try {
            // Fetching by primary key
            return (Recipient) session.get(Recipient.class, hId);  // Assuming hId is your PK
        } finally {
            session.close();
        }
    }
    
    


	
}
