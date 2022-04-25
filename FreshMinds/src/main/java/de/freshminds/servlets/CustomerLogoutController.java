package de.freshminds.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.freshminds.manager.CustomerManager;

@WebServlet("/logout")
public class CustomerLogoutController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private CustomerManager customerManager;

    public void init() {
    	customerManager = new CustomerManager();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		customerManager.logout(request, response);
	}

}
