package de.freshminds.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.freshminds.entities.Article;
import de.freshminds.entities.Category;
import de.freshminds.entities.Delivery;
import de.freshminds.entities.Stock;
import de.freshminds.entities.Transaction;
import de.freshminds.manager.ArticleManager;
import de.freshminds.manager.CustomerManager;
import de.freshminds.manager.DeliveryManager;
import de.freshminds.manager.SessionManager;
import de.freshminds.manager.TransactionManager;

@WebServlet("/orders")
public class CustomerOrdersController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private SessionManager sessionManager;
	private DeliveryManager deliveryManager;
	private TransactionManager transactionManager;
	private ArticleManager articleManager;

	public void init() {
		sessionManager = new SessionManager();
		deliveryManager = new DeliveryManager();
		transactionManager = new TransactionManager();
		articleManager = new ArticleManager();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		fillOrdersTable(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		fillOrdersTable(request, response);
	
	}
	
	private void fillOrdersTable(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<Transaction> transactions = transactionManager.getTransactionsByUsername(sessionManager.getString(request, "customerUsername"));
		List<Delivery> deliveries = deliveryManager.getDeliveriesByUsername(sessionManager.getString(request, "customerUsername"));
		
		sessionManager.setObject(request, "transactions", transactions);
		sessionManager.setObject(request, "deliveries", deliveries);
		
		for (Transaction transaction : transactions) {
			if (sessionManager.getString(request, Integer.toString(transaction.getTransactionNumber())) == null) {
				Article article = articleManager.getArticle(transaction.getArticleNumber());
				sessionManager.setString(request, Integer.toString(transaction.getTransactionNumber()), article.getArticleName());
			}

		}
				
		response.sendRedirect("logged_in/orders.jsp");
	}
	
}
