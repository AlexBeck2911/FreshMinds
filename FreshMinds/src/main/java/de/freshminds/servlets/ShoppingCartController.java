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
import de.freshminds.entities.Customer;
import de.freshminds.entities.ShoppingCart;
import de.freshminds.manager.ArticleManager;
import de.freshminds.manager.CategoryManager;
import de.freshminds.manager.DeliveryManager;
import de.freshminds.manager.SessionManager;
import de.freshminds.manager.ShoppingCartManager;
import de.freshminds.manager.StockManager;
import de.freshminds.manager.TransactionManager;

@WebServlet("/shoppingcart")
public class ShoppingCartController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private SessionManager sessionManager;
	private DeliveryManager deliveryManager;
	private TransactionManager transactionManager;
	private ArticleManager articleManager;
	private ShoppingCartManager shoppingCartManager;
	private StockManager stockManager;
	private CategoryManager categoryManager;

	public void init() {
		sessionManager = new SessionManager();
		deliveryManager = new DeliveryManager();
		transactionManager = new TransactionManager();
		articleManager = new ArticleManager();
		shoppingCartManager = new ShoppingCartManager();
		stockManager = new StockManager();
		categoryManager = new CategoryManager();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		fillShoppingCartTable(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		fillShoppingCartTable(request, response);
	
	}
	
	private void fillShoppingCartTable(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Customer customer = (Customer) sessionManager.getObject(request, "customer");
		List<ShoppingCart> shoppingCart = shoppingCartManager.getAllItems(customer.getUsername());
		
		sessionManager.setString(request, "country", customer.getCountry());
		sessionManager.setString(request, "city", customer.getCity());
		sessionManager.setString(request, "street", customer.getStreet());
		sessionManager.setString(request, "postalCode", customer.getPostalCode());
		
		sessionManager.setObject(request, "shoppingCart", shoppingCart);
		
		Double totalPrice = 0.0;
		
		List<Double> totalItemPrice = new ArrayList<>();
		
		for(ShoppingCart item: shoppingCart) {
			totalPrice = totalPrice + item.getPrice() * item.getAmount();
			totalItemPrice.add(item.getAmount() * item.getPrice());
			if (sessionManager.getString(request, Integer.toString(item.getArticleNumber())) == null) {
				Article article = articleManager.getArticle(item.getArticleNumber());
				sessionManager.setString(request, Integer.toString(item.getArticleNumber()), article.getArticleName());
			}
		}

		sessionManager.setString(request, "totalPrice", totalPrice.toString());
		sessionManager.setObject(request, "totalItemPrice", totalItemPrice);
		response.sendRedirect("logged_in/shoppingCart.jsp");
		
	}
		
}
