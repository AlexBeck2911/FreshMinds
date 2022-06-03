package de.freshminds.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
import de.freshminds.manager.StockManager;
import de.freshminds.manager.TransactionManager;

@WebServlet("/buy")
public class ArticleBuyController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private ArticleManager articleManager;
    private SessionManager sessionManager;
    private StockManager stockManager;
    private TransactionManager transactionManager;
    private DeliveryManager deliveryManager;

    public void init() {
    	articleManager = new ArticleManager();
    	sessionManager = new SessionManager();
    	stockManager = new StockManager();
    	transactionManager = new TransactionManager();
    	deliveryManager = new DeliveryManager();
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
    	
    	int orderAmount = Integer.parseInt(request.getParameter("amountRange"));
    	Double articlePrice = Double.valueOf(sessionManager.getString(request, "articlePrice")); 
    	Random rnd = new Random();
    	int transactionNumber = rnd.nextInt(999999999);
    	String username = sessionManager.getString(request, "customerUsername");
    	int articleID = Integer.parseInt(sessionManager.getString(request, "articleID"));
    	String paymentMethod = request.getParameter("paymentMethod");
    	Date date = new Date(System.currentTimeMillis());
    	    	
    	transactionManager.create(transactionNumber, username, articleID, orderAmount, articlePrice, paymentMethod, date);
    	
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
    	
    	stockManager.update(articleID, stockManager.getStock(articleID).getArticleAmount() - orderAmount);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/orders");
    	dispatcher.forward(request,response);
  
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int articleID = Integer.parseInt(request.getParameter("articleID"));
		Customer customer = (Customer) sessionManager.getObject(request, "customer");
		Article article = articleManager.getArticle(articleID);
		Stock stock = stockManager.getStock(articleID);
		
		sessionManager.setString(request, "articleID", Integer.toString(articleID));
		sessionManager.setString(request, "articleName", article.getArticleName());
		sessionManager.setString(request, "articlePrice", Double.toString(article.getArticlePrice()));
		sessionManager.setString(request, "availability", Integer.toString(stock.getArticleAmount()));
		
		sessionManager.setString(request, "country", customer.getCountry());
		sessionManager.setString(request, "city", customer.getCity());
		sessionManager.setString(request, "street", customer.getStreet());
		sessionManager.setString(request, "postalCode", customer.getPostalCode());
		   	
		response.sendRedirect("logged_in/buy.jsp");

	}
    
}