package de.freshminds.manager;

import org.hibernate.Session;

import de.freshminds.entities.Article;
import de.freshminds.main.Core;

public class ArticleManager {

	public static void create(int articleNumber, String articleName, double articlePrice, String articleOrigin,
			int articleCategory) {

		Article article = new Article();
		article.setArticleNumber(articleNumber);
		article.setArticleName(articleName);
		article.setArticlePrice(articlePrice);
		article.setArticleOrigin(articleOrigin);
		article.setArticleCategory(articleCategory);

		Session session = Core.freshMindsSessionFactory.openSession();
		session.beginTransaction();

		session.save(article);

		session.getTransaction().commit();
		session.close();
	}

	public static void update(int articleNumber, String articleName, double articlePrice, String articleOrigin,
			Integer articleCategory) {
		
		Article article = new Article();
		article.setArticleNumber(articleNumber);
		article.setArticleName(articleName);
		article.setArticlePrice(articlePrice);
		article.setArticleOrigin(articleOrigin);
		article.setArticleCategory(articleCategory);

		Session session = Core.freshMindsSessionFactory.openSession();
		session.beginTransaction();

		session.update(article);

		session.getTransaction().commit();
		session.close();
	}
	
	public static void delete(int articleNumber) {
		
		Article article = new Article();
		article.setArticleNumber(articleNumber);
	 
	    Session session = Core.freshMindsSessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(article);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
