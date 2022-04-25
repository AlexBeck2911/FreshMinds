package de.freshminds.servlets;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.freshminds.entities.Customer;
import de.freshminds.main.Core;
import de.freshminds.manager.CustomerManager;

@WebServlet("/register")
public class CustomerRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerManager customerManager;

	public void init() {
		customerManager = new CustomerManager();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		register(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/methods/auth/register.jsp");
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String username = request.getParameter("Username");
		String birthdate = request.getParameter("Birthdate");
        String firstName = request.getParameter("Firstname");
        String lastName = request.getParameter("Lastname");
        String password = customerManager.encrypt(request.getParameter("Password"));
        String email = request.getParameter("Email");
        String paymentMethod = "";
        String phonenumber = request.getParameter("Phonenumber");
        String country = request.getParameter("Country");
        String city = request.getParameter("City");
        String street = request.getParameter("Street");
        String postalCode = request.getParameter("PostalCode");

        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setFirstname(firstName);
        customer.setLastname(lastName);
        customer.setEmail(email);
        customer.setPhoneNumber(phonenumber);
        customer.setPaymentMethod(paymentMethod);
        customer.setBirthdate(birthdate);
        customer.setCountry(country);
        customer.setCity(city);
        customer.setStreet(street);
        customer.setPostalCode(postalCode);

        customerManager.saveCustomer(customer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/methods/auth/login.jsp");
        dispatcher.forward(request, response);
    }

}
