package de.freshminds.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.freshminds.entities.Article;
import de.freshminds.entities.Category;
import de.freshminds.entities.Stock;
import de.freshminds.manager.ArticleManager;
import de.freshminds.manager.CategoryManager;
import de.freshminds.manager.SessionManager;
import de.freshminds.manager.ShoppingCartManager;
import de.freshminds.manager.StockManager;

@WebServlet("/home")
public class CustomerHomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private SessionManager sessionManager;
	private ArticleManager articleManager;
	private CategoryManager categoryManager;
	private StockManager stockManager;
	private ShoppingCartManager shoppingCartManager;

	public void init() {
		sessionManager = new SessionManager();
		articleManager = new ArticleManager();
		categoryManager = new CategoryManager();
		stockManager = new StockManager();
		shoppingCartManager = new ShoppingCartManager();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			listArticles(request, response);
		} catch (SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			listArticles(request, response);
		} catch (SQLException | IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listArticles(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Article> listArticles = articleManager.getArticles();
		List<Stock> listStocks = stockManager.getStocks();
		sessionManager.setObject(request, "listArticles", listArticles);
		sessionManager.setObject(request, "listStocks", listStocks);
		
		List<Boolean> inShoppingCart = new ArrayList<Boolean>();

		for (Article article : listArticles) {
			if (sessionManager.getString(request, Integer.toString(article.getArticleCategory())) == null) {
				Category category = categoryManager.getCategory(article.getArticleCategory());
				sessionManager.setString(request, Integer.toString(article.getArticleCategory()), category.getCategoryDesignation());
			}
			if(shoppingCartManager.containsArticle(article.getArticleNumber(), sessionManager.getString(request, "customerUsername"))) {
				inShoppingCart.add(true);
			} else {
				inShoppingCart.add(false);
			}
		}
		
		sessionManager.setObject(request, "inShoppingCart", inShoppingCart);
		
		response.sendRedirect("logged_in/home.jsp");
		
	}

}
