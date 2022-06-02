package de.freshminds.manager;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import de.freshminds.entities.Article;
import de.freshminds.entities.Category;
import de.freshminds.entities.Customer;
import de.freshminds.entities.Stock;
import de.freshminds.main.Core;

public class CustomerManager {
	
	private SessionManager sessionManager = new SessionManager();

	public void saveCustomer(Customer customer) {

		Session session = Core.customerSessionFactory.openSession();
		session.beginTransaction();

		session.save(customer);

		session.getTransaction().commit();
		session.close();

	}

	public String encrypt(String password) {
		try {
			final MessageDigest digest = MessageDigest.getInstance("md5");
			digest.update(password.getBytes());
			final byte[] bytes = digest.digest();
			final StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(String.format("%02X", bytes[i]));
			}
			return sb.toString().toLowerCase();
		} catch (Exception exc) {
			return "";
		}
	}

	public Customer getCustomerByUsername(String username) {
		Session session = Core.customerSessionFactory.openSession();
		session.beginTransaction();

		Customer customer = session.get(Customer.class, username);
		session.getTransaction().commit();

		return customer;
	}

	public boolean validate(String Username, String password) {

		Transaction transaction = null;
		Customer Customer = null;
		Session session = Core.customerSessionFactory.openSession();
		transaction = session.beginTransaction();
		Customer = (Customer) session.createQuery("FROM Customer WHERE Username = :Username")
				.setParameter("Username", Username).uniqueResult();

		if (Customer != null && Customer.getPassword().equals(password)) {
			return true;
		}
		transaction.commit();

		return false;
	}
	
	public void login(Customer customer, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sessionManager.setObject(request, "customer", customer);
		sessionManager.setString(request, "customerUsername", customer.getUsername());
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
    	dispatcher.forward(request,response);
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sessionManager.removeObject(request, "customer");
		sessionManager.removeString(request, "customerUsername");
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
	}
	
}
