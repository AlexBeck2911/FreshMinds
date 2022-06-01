package de.freshminds.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.freshminds.entities.Article;
import de.freshminds.manager.ArticleManager;
import de.freshminds.manager.CustomerManager;
import de.freshminds.manager.SessionManager;

@WebServlet("/buy")
public class ArticleBuyController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private CustomerManager customerManager;
    private ArticleManager articleManager;
    private SessionManager sessionManager;

    public void init() {
    	customerManager = new CustomerManager();
    	articleManager = new ArticleManager();
    	sessionManager = new SessionManager();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int articleID = Integer.parseInt(request.getParameter("articleID"));
		Article article = articleManager.getArticle(articleID);
		
		sessionManager.setString(request, "articleID", Integer.toString(articleID));
		//sessionManager.set
    	
		response.sendRedirect("logged_in/buy.jsp");
		System.out.println("Hallo");
	}
    
}