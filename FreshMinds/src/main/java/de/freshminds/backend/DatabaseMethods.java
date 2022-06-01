package de.freshminds.backend;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import de.freshminds.entities.Article;
import de.freshminds.entities.Category;
import de.freshminds.entities.Stock;
import de.freshminds.main.Core;

public class DatabaseMethods {
	
	public static void fillArticlesTable() {
	
		List<Article> articles = new ArrayList<Article>();
		
		articles.add(new Article(1001, "Roggenmischbrot", 1.80, "GER", 1));
		articles.add(new Article(1002, "Bauernbrot", 1.67, "GER", 1));
		articles.add(new Article(1003, "Glutenfreies Landbrot", 1.77, "GER", 1));
		articles.add(new Article(1004, "Dinkelbrot", 1.63, "GER", 1));
		articles.add(new Article(1005, "Weizenmischbrot", 1.99, "POL", 1));
		articles.add(new Article(1006, "Vollkornbrot", 2.10, "GER", 1));
		articles.add(new Article(1007, "Rosinenbrot", 1.41, "POL", 1));
		articles.add(new Article(1008, "Kasten-Weißbrot", 2.07, "GER", 1));
		articles.add(new Article(1009, "Weißbrot", 2.15, "GER", 1));
		articles.add(new Article(1010, "Toastbrot", 1.92, "GER", 1));
		articles.add(new Article(2001, "Brötchen", 0.15, "GER", 2));
		articles.add(new Article(2002, "Doppelbrötchen", 0.21, "GER", 2));
		articles.add(new Article(2003, "Vollkornbrötchen", 0.22, "GER", 2));
		
		Session freshMindsSession = Core.articlesSessionFactory.openSession();
		freshMindsSession.beginTransaction();
		
		for(Article article : articles)  {
			freshMindsSession.saveOrUpdate(article);
		}
		freshMindsSession.getTransaction().commit();
		freshMindsSession.close();
	}
	
	public static void fillStockTable() {
		
		List<Stock> stock = new ArrayList<Stock>();
		
		stock.add(new Stock(1001, 500));
		stock.add(new Stock(1002, 500));
		stock.add(new Stock(1003, 500));
		stock.add(new Stock(1004, 500));
		stock.add(new Stock(1005, 500));
		stock.add(new Stock(1006, 500));
		stock.add(new Stock(1007, 500));
		stock.add(new Stock(1008, 500));
		stock.add(new Stock(1009, 500));
		stock.add(new Stock(1010, 500));
		stock.add(new Stock(2001, 500));
		stock.add(new Stock(2002, 500));
		stock.add(new Stock(2003, 500));
		
		Session freshMindsSession = Core.articlesSessionFactory.openSession();
		freshMindsSession.beginTransaction();
		
		for(Stock articleStock : stock)  {
			freshMindsSession.saveOrUpdate(articleStock);
		}
		freshMindsSession.getTransaction().commit();
		freshMindsSession.close();
	}
	
	public static void fillCategoriesTable() {
		
		List<Category> categories = new ArrayList<Category>();
		
		categories.add(new Category(1, "Brot"));
		categories.add(new Category(2, "Brötchen"));
		
		Session freshMindsSession = Core.articlesSessionFactory.openSession();
		freshMindsSession.beginTransaction();
		
		for(Category category : categories)  {
			freshMindsSession.saveOrUpdate(category);
		}
		freshMindsSession.getTransaction().commit();
		freshMindsSession.close();
	}

}
