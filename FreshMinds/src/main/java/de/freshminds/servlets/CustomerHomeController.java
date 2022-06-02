package de.freshminds.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.freshminds.entities.Article;
import de.freshminds.entities.Category;
import de.freshminds.entities.Customer;
import de.freshminds.entities.Stock;
import de.freshminds.manager.ArticleManager;
import de.freshminds.manager.CategoryManager;
import de.freshminds.manager.CustomerManager;
import de.freshminds.manager.SessionManager;
import de.freshminds.manager.StockManager;

@WebServlet("/home")
public class CustomerHomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private SessionManager sessionManager;
	private ArticleManager articleManager;
	private CategoryManager categoryManager;
	private StockManager stockManager;

	public void init() {
		sessionManager = new SessionManager();
		articleManager = new ArticleManager();
		categoryManager = new CategoryManager();
		stockManager = new StockManager();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Get");
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
		sessionManager.setObject(request, "listArticles", listArticles);

		for (Article article : listArticles) {
			if (sessionManager.getString(request, Integer.toString(article.getArticleCategory())) == null) {
				Category category = categoryManager.getCategory(article.getArticleCategory());
				sessionManager.setString(request, Integer.toString(article.getArticleCategory()), category.getCategoryDesignation());
			}
			Stock stock = stockManager.getStock(article.getArticleNumber());
			sessionManager.setString(request, Integer.toString(article.getArticleNumber()), Integer.toString(stock.getArticleAmount()));
		}
		response.sendRedirect("logged_in/home.jsp");
		
	}

}
