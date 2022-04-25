package de.freshminds.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.freshminds.entities.Customer;
import de.freshminds.manager.CustomerManager;

@WebServlet("/login")
public class CustomerLoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CustomerManager customerManager;

	public void init() {
		customerManager = new CustomerManager();
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
		System.out.println(username);
		String password = customerManager.encrypt(request.getParameter("Password"));

		if (customerManager.validate(username, password)) {
			Customer customer = customerManager.getCustomerByUsername(username);
			customerManager.login(customer, request, response);
		} else {
			throw new Exception("Der Login war nicht erfolgreich!");
		}
	}

}
