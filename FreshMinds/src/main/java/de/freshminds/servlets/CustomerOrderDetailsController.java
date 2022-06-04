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
import de.freshminds.entities.Transaction;
import de.freshminds.manager.ArticleManager;
import de.freshminds.manager.SessionManager;
import de.freshminds.manager.TransactionManager;

@WebServlet("/details")
public class CustomerOrderDetailsController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private SessionManager sessionManager;
	private TransactionManager transactionManager;
	private ArticleManager articleManager;

	public void init() {
		sessionManager = new SessionManager();
		transactionManager = new TransactionManager();
		articleManager = new ArticleManager();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		fillOrderDetailsTable(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		fillOrderDetailsTable(request, response);
	
	}
	
	private void fillOrderDetailsTable(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int transactionNumber = Integer.parseInt(request.getParameter("transactionNumber"));
		List<String> articleNames = new ArrayList<String>();
		
		for(Transaction transaction: transactionManager.getItemsByTransaction(transactionNumber)) {
			Article article = articleManager.getArticle(transaction.getArticleNumber());
			articleNames.add(article.getArticleName());
		}
		
		sessionManager.setString(request, "transactionNumber", request.getParameter("transactionNumber"));
		sessionManager.setObject(request, "transactionDetails", transactionManager.getItemsByTransaction(transactionNumber));
		sessionManager.setObject(request, "articleNames", articleNames);
										
		response.sendRedirect("logged_in/details.jsp");
	}
	
}
