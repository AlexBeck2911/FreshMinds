package de.freshminds.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.freshminds.entities.ShoppingCart;
import de.freshminds.manager.ArticleManager;
import de.freshminds.manager.DeliveryManager;
import de.freshminds.manager.SessionManager;
import de.freshminds.manager.ShoppingCartManager;
import de.freshminds.manager.StockManager;
import de.freshminds.manager.TransactionManager;

@WebServlet("/buy")
public class ArticleBuyController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private SessionManager sessionManager;
    private StockManager stockManager;
    private TransactionManager transactionManager;
    private DeliveryManager deliveryManager;
    private ShoppingCartManager shoppingCartManager;

    public void init() {
    	sessionManager = new SessionManager();
    	stockManager = new StockManager();
    	transactionManager = new TransactionManager();
    	deliveryManager = new DeliveryManager();
    	shoppingCartManager = new ShoppingCartManager();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processOrder(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void processOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException, ServletException {
    	
    	String username = sessionManager.getString(request, "customerUsername");	
    	List<ShoppingCart> shoppingCart = shoppingCartManager.getAllItems(username);
    	Random rnd = new Random();	
    	int transactionNumber = rnd.nextInt(999999999);
    	String paymentMethod = request.getParameter("paymentMethod");
    	Date date = new Date(System.currentTimeMillis());
    	
    	for(ShoppingCart shoppingCartItem: shoppingCart) {
    		transactionManager.create(transactionNumber, username, shoppingCartItem.getArticleNumber(), shoppingCartItem.getAmount(), shoppingCartItem.getAmount() * shoppingCartItem.getPrice(), paymentMethod, date, 1);    		
    		stockManager.update(shoppingCartItem.getArticleNumber(), stockManager.getStock(shoppingCartItem.getArticleNumber()).getArticleAmount() - shoppingCartItem.getAmount());
    	}
    	
    	int deliveryNumber = rnd.nextInt(999999999);
    	String country = request.getParameter("Country");
    	String city = request.getParameter("City");
    	String street = request.getParameter("Street");
    	String postalCode = request.getParameter("PostalCode");
    	String delivery = request.getParameter("delivery_date");
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    	long l = sdf.parse(delivery).getTime(); 
    	Date deliveryDate = new Date(l);
    	
    	deliveryManager.create(deliveryNumber, transactionNumber, username, country, city, street, postalCode, deliveryDate);
    	
    	shoppingCartManager.clearShoppingCart(username);
    	   	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/orders");
    	dispatcher.forward(request,response);
  
    }
   
}