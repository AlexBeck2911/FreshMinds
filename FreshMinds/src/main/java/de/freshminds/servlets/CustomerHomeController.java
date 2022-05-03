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
import de.freshminds.manager.ArticleManager;

@WebServlet("/")
public class CustomerHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleManager articleManager;

	public void init() {
		articleManager = new ArticleManager();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String action = request.getServletPath();
//
//		try {
//			switch (action) {
//			case "/test":
//				break;
//			default:
//
//				break;
//			}
//		} catch (SQLException ex) {
//			throw new ServletException(ex);
//		}
//	}

}
