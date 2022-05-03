package de.freshminds.manager;

import java.util.List;

import org.hibernate.Session;

import de.freshminds.entities.Article;
import de.freshminds.main.Core;

public class ArticleManager {

	public void create(int articleNumber, String articleName, double articlePrice, String articleOrigin,
			int articleCategory) {

		Article article = new Article();
		article.setArticleNumber(articleNumber);
		article.setArticleName(articleName);
		article.setArticlePrice(articlePrice);
		article.setArticleOrigin(articleOrigin);
		article.setArticleCategory(articleCategory);

		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();

		session.save(article);

		session.getTransaction().commit();
		session.close();
	}

	public void update(int articleNumber, String articleName, double articlePrice, String articleOrigin,
			Integer articleCategory) {

		Article article = new Article();
		article.setArticleNumber(articleNumber);
		article.setArticleName(articleName);
		article.setArticlePrice(articlePrice);
		article.setArticleOrigin(articleOrigin);
		article.setArticleCategory(articleCategory);

		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();

		session.update(article);

		session.getTransaction().commit();
		session.close();
	}

	public void delete(int articleNumber) {

		Article article = new Article();
		article.setArticleNumber(articleNumber);

		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();

		session.delete(article);

		session.getTransaction().commit();
		session.close();
	}

	public Article getArticle(int id) {
		
		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();
		
		Article article = session.get(Article.class, id);
		
		session.getTransaction().commit();
		
		return article;
	}

	public List<Article> getArticles() {
		
		Session session = Core.articlesSessionFactory.openSession();
	    session.beginTransaction();
	    List<Article> articles = (List<Article>) session.createQuery("from Article").list();
	    session.getTransaction().commit();
	    
	    return articles;
		
	}

}
