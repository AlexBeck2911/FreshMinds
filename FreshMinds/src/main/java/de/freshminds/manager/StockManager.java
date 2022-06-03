package de.freshminds.manager;

import java.util.List;

import org.hibernate.Session;

import de.freshminds.entities.Article;
import de.freshminds.entities.Stock;
import de.freshminds.main.Core;

public class StockManager {

	public void update(int articleNumber, int amount) {

		Stock stock = new Stock();
		stock.setArticleNumber(articleNumber);
		stock.setArticleAmount(amount);

		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();

		session.update(stock);

		session.getTransaction().commit();
		session.close();
	}

	public Stock getStock(int articleID) {

		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();

		Stock stock = session.get(Stock.class, articleID);

		session.getTransaction().commit();

		return stock;
	}

	public List<Stock> getStocks() {

		Session session = Core.articlesSessionFactory.openSession();
		session.beginTransaction();
		List<Stock> stocks = (List<Stock>) session.createQuery("from Stock").list();
		session.getTransaction().commit();

		return stocks;

	}

}
