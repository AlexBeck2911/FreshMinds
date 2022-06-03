package de.freshminds.manager;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import de.freshminds.entities.Article;
import de.freshminds.entities.Delivery;
import de.freshminds.entities.Transaction;
import de.freshminds.main.Core;

public class DeliveryManager {
	
	public void create(int deliveryNumber, int transactionNumber, String username, String country, String city,
			String street, String postalCode, Date deliveryDate) {

		Delivery delivery = new Delivery(deliveryNumber, transactionNumber, username, country, city, street, postalCode, deliveryDate);

		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();

		session.save(delivery);

		session.getTransaction().commit();
		session.close();
	}
	
	public Delivery getDeliveryByTransactionNumber(int transactionNumber) {
		
		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();
		
		String hql = "FROM Delivery WHERE TransactionNumber = :transactionNumber";
	    Query query = session.createQuery(hql);
	    query.setParameter("transactionNumber", transactionNumber);
	    List<Delivery> deliveries = query.list();
		
		return deliveries.get(0);
	}
	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public List<Delivery> getDeliveriesByUsername(String username) {
		
		Session session = Core.articlesSessionFactory.openSession();
	    session.beginTransaction();
	    
	    String hql = "FROM Delivery WHERE Username = :username";
	    Query query = session.createQuery(hql);
	    query.setParameter("username", username);
	    List<Delivery> deliveries = query.list();
	    
	    session.close();
	    	   
	    return deliveries;
	}

}
