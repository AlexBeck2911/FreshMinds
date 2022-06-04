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
import de.freshminds.entities.Delivery;
import de.freshminds.entities.Transaction;
import de.freshminds.manager.ArticleManager;
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
		
		String username = sessionManager.getString(request, "customerUsername");
		
		List<Transaction> transactions = transactionManager.getTransactionsByUsername(username);
		List<Transaction> completeTransactions = transactionManager.getFullTransactionsByUsername(username);
		List<Delivery> deliveries = new ArrayList<Delivery>();
					
		sessionManager.setObject(request, "transactions", transactions);
			
		for (Transaction transaction : transactions) {	
			
			if (sessionManager.getString(request, Integer.toString(transaction.getTransactionNumber())) == null) {
				Article article = articleManager.getArticle(transaction.getArticleNumber());
				sessionManager.setString(request, Integer.toString(transaction.getTransactionNumber()), article.getArticleName());
			}
			
		}
		
		List<Integer> totalAmounts = new ArrayList<Integer>();
		List<Double> totalPrices = new ArrayList<Double>();
		
		for(Transaction transaction: completeTransactions) {
			deliveries.add(deliveryManager.getDeliveryByTransactionNumber(transaction.getTransactionNumber()));
			int totalAmount = 0;
			double totalPrice = 0.0;
			for(Transaction transactionItem: transactionManager.getItemsByTransaction(transaction.getTransactionNumber())) {
				totalAmount = totalAmount + transactionItem.getAmount();
				totalPrice = totalPrice + transactionItem.getPrice();
			}
			totalAmounts.add(totalAmount);
			totalPrices.add(totalPrice);
			sessionManager.setObject(request, "delivery_" + Integer.toString(transaction.getTransactionNumber()), transactionManager.getItemsByTransaction(transaction.getTransactionNumber()));
		}
		
		sessionManager.setObject(request, "totalAmount", totalAmounts);
		sessionManager.setObject(request, "totalPrice", totalPrices);
		sessionManager.setObject(request, "completeTransactions", completeTransactions);
		
		sessionManager.setObject(request, "deliveries", deliveries);
				
		response.sendRedirect("logged_in/orders.jsp");
	}
	
}
