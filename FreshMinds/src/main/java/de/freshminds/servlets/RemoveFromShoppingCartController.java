package de.freshminds.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.freshminds.manager.ShoppingCartManager;

@WebServlet("/removefromshoppingcart")
public class RemoveFromShoppingCartController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ShoppingCartManager shoppingCartManager;

	public void init() {
		shoppingCartManager = new ShoppingCartManager();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		removeFromShoppingCart(request, response);
		
	}

	private void removeFromShoppingCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		shoppingCartManager.deleteShoppingCartItem(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/shoppingcart");
    	dispatcher.forward(request,response);
		
	}
		
}
