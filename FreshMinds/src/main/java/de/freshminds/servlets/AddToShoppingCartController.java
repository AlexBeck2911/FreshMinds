package de.freshminds.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.freshminds.entities.Article;
import de.freshminds.entities.Customer;
import de.freshminds.entities.Stock;
import de.freshminds.manager.ArticleManager;
import de.freshminds.manager.DeliveryManager;
import de.freshminds.manager.SessionManager;
import de.freshminds.manager.ShoppingCartManager;
import de.freshminds.manager.StockManager;
import de.freshminds.manager.TransactionManager;

@WebServlet("/addtoshoppingcart")
public class AddToShoppingCartController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private SessionManager sessionManager;
	private DeliveryManager deliveryManager;
	private TransactionManager transactionManager;
	private ArticleManager articleManager;
	private ShoppingCartManager shoppingCartManager;
	private StockManager stockManager;

	public void init() {
		sessionManager = new SessionManager();
		deliveryManager = new DeliveryManager();
		transactionManager = new TransactionManager();
		articleManager = new ArticleManager();
		shoppingCartManager = new ShoppingCartManager();
		stockManager = new StockManager();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int articleID = Integer.parseInt(request.getParameter("articleID"));
		Article article = articleManager.getArticle(articleID);
		Stock stock = stockManager.getStock(articleID);
		
		sessionManager.setString(request, "articleID", Integer.toString(articleID));
		sessionManager.setString(request, "articleName", article.getArticleName());
		sessionManager.setString(request, "articlePrice", Double.toString(article.getArticlePrice()));
		sessionManager.setString(request, "availability", Integer.toString(stock.getArticleAmount()));
		
		response.sendRedirect("logged_in/add.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		addToShoppingCart(request, response);
	
	}
	
	private void addToShoppingCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int orderAmount = Integer.parseInt(request.getParameter("amountRange"));
    	Double articlePrice = Double.valueOf(sessionManager.getString(request, "articlePrice")); 
    	String username = sessionManager.getString(request, "customerUsername");
    	int articleID = Integer.parseInt(sessionManager.getString(request, "articleID"));

    	shoppingCartManager.addItemToShoppingCart(username, articleID, orderAmount, articlePrice);
				
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/shoppingcart");
    	dispatcher.forward(request,response);
	}
	
}
