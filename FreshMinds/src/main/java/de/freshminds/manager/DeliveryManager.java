package de.freshminds.manager;

import java.util.Date;

import org.hibernate.Session;

import de.freshminds.entities.Article;
import de.freshminds.entities.Delivery;
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

}
