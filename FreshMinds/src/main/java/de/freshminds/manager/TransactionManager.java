package de.freshminds.manager;

import java.util.Date;

import org.hibernate.Session;

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

}
