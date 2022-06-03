package de.freshminds.manager;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import de.freshminds.entities.Transaction;
import de.freshminds.main.Core;

public class TransactionManager {
	
	public void create(int transactionNumber, String username, int articleNumber, int amount, double price, String paymentMethod, Date timestamp) {

		Transaction transaction = new Transaction(transactionNumber, username, articleNumber, amount, price, paymentMethod, timestamp);

		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();

		session.save(transaction);

		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public List<Transaction> getTransactionsByUsername(String username) {
		
		Session session = Core.articlesSessionFactory.openSession();
	    session.beginTransaction();
	    
	    String hql = "FROM Transaction WHERE Username = :username";
	    Query query = session.createQuery(hql);
	    query.setParameter("username", username);
	    List<Transaction> transactions = query.list();
	    	   
	    return transactions;
	}

}
