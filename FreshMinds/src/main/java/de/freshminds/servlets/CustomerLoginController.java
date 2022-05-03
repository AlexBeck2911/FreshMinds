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
import javax.servlet.http.HttpSession;

import de.freshminds.entities.Article;
import de.freshminds.entities.Customer;
import de.freshminds.manager.ArticleManager;
import de.freshminds.manager.CustomerManager;
import de.freshminds.manager.SessionManager;

@WebServlet("/login")
public class CustomerLoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CustomerManager customerManager;
	private SessionManager sessionManager;
	private ArticleManager articleManager;

	public void init() {
		customerManager = new CustomerManager();
		sessionManager = new SessionManager();
		articleManager = new ArticleManager();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("methods/auth/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			authenticate(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("Username");
		String password = customerManager.encrypt(request.getParameter("Password"));

		if (customerManager.validate(username, password)) {
			Customer customer = customerManager.getCustomerByUsername(username);
			sessionManager.removeString(request, "loginError");
			listUser(request, response);
			customerManager.login(customer, request, response);
			
		} else {
			sessionManager.setString(request, "loginError", "Falsches Passwort!");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("");
	        dispatcher.forward(request, response);
		}
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	        List<Article> listUser = articleManager.getArticles();
    	        System.out.println(listUser);
    	        request.setAttribute("listArticles", listUser);
    	    }

}
