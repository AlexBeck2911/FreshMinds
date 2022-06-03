package de.freshminds.manager;

import java.util.List;

import org.hibernate.Session;

import de.freshminds.entities.Article;
import de.freshminds.entities.Category;
import de.freshminds.entities.Stock;
import de.freshminds.main.Core;

public class CategoryManager {
	
	public void create(int categoryNumber, String categoryDesignation) {

		Category category = new Category();
		category.setCategoryNumber(categoryNumber);
		category.setCategoryDesignation(categoryDesignation);

		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();

		session.save(category);

		session.getTransaction().commit();
		session.close();
	}

	public void update(int categoryNumber, String categoryDesignation) {
		
		Category category = new Category();
		category.setCategoryNumber(categoryNumber);
		category.setCategoryDesignation(categoryDesignation);

		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();

		session.update(category);

		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(int categoryNumber) {
		
		Category category = new Category();
		category.setCategoryNumber(categoryNumber);
	 
	    Session session = Core.articlesSessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(category);
	 
	    session.getTransaction().commit();
	    session.close();
	}
	
	public Category getCategory(int id) {
		
		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();
		
		Category category = session.get(Category.class, id);
		
		session.getTransaction().commit();
		
		return category;
	}
	
	public List<Category> getCategories() {

		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();
		List<Category> categories = (List<Category>) session.createQuery("from Category").list();
		session.getTransaction().commit();

		return categories;

	}

}
