package de.freshminds.manager;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import de.freshminds.entities.Delivery;
import de.freshminds.entities.ShoppingCart;
import de.freshminds.main.Core;

public class ShoppingCartManager {
	
	public void addItemToShoppingCart(String username, int articleNumber, int amount, double price) {

		ShoppingCart shoppingCart = new ShoppingCart(username, articleNumber, amount, price, 1);

		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();

		session.save(shoppingCart);

		session.getTransaction().commit();
		session.close();
	}
	
	public List<ShoppingCart> getAllItems(String username) {
		
		Session session = Core.articlesSessionFactory.openSession();
	    session.beginTransaction();
	    
	    String hql = "FROM ShoppingCart WHERE Username = :username";
	    Query query = session.createQuery(hql);
	    query.setParameter("username", username);
	    List<ShoppingCart> shoppingCart = query.list();
	    
	    session.close();
	    	   
	    return shoppingCart;
		
	}
	
	public void clearShoppingCart(String username) {
		
		Session session = Core.articlesSessionFactory.openSession();
	    session.beginTransaction();
	    
	    String hql = "DELETE FROM ShoppingCart WHERE Username = :username";
	    Query query = session.createQuery(hql);
	    query.setParameter("username", username);
	    query.executeUpdate();
	    
	    session.close();
		
	}

}
