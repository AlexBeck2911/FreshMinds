package de.freshminds.manager;

import org.hibernate.Session;

import de.freshminds.entities.Category;
import de.freshminds.main.Core;

public class CategoryManager {
	
	public static void create(int categoryNumber, String categoryDesignation) {

		Category category = new Category();
		category.setCategoryNumber(categoryNumber);
		category.setCategoryDesignation(categoryDesignation);

		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();

		session.save(category);

		session.getTransaction().commit();
		session.close();
	}

	public static void update(int categoryNumber, String categoryDesignation) {
		
		Category category = new Category();
		category.setCategoryNumber(categoryNumber);
		category.setCategoryDesignation(categoryDesignation);

		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();

		session.update(category);

		session.getTransaction().commit();
		session.close();
	}
	
	public static void delete(int categoryNumber) {
		
		Category category = new Category();
		category.setCategoryNumber(categoryNumber);
	 
	    Session session = Core.articlesSessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(category);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
