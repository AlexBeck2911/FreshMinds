package de.freshminds.manager;

import org.hibernate.Session;

import de.freshminds.entities.Customer;
import de.freshminds.main.Core;

public class CustomerManager {
	
	public void saveCustomer(Customer customer) {
		
		Session session = Core.customerSessionFactory.openSession();
		session.beginTransaction();

		session.save(customer);

		session.getTransaction().commit();
		session.close();
		
	}

}
