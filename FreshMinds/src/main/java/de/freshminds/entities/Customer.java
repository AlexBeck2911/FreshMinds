package de.freshminds.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable{
	private static final long serialVersionUID = 123570238;
	
	@Id
	@Column(name = "Username", length = 40)
	private String username;
	
	@Column(name = "Password", length = 100, nullable = true, unique = false)
	private String password;
	
	@Column(name = "Firstname", length = 100, nullable = true, unique = false)
	private String firstname;
	
	@Column(name = "Lastname", length = 100, nullable = true, unique = false)
	private String lastname;
	
	@Column(name = "Birthdate", length = 100, nullable = true, unique = false)
	private String birthdate;
	
	@Column(name = "Email", length = 100, nullable = true, unique = false)
	private String email;
	
	@Column(name = "Phonenumber", length = 100, nullable = true, unique = false)
	private String phoneNumber;
	
	@Column(name = "PaymentMethod", length = 100, nullable = true, unique = false)
	private String paymentMethod;
	
	@Column(name = "Country", length = 100, nullable = true, unique = false)
	private String country;
	
	@Column(name = "City", length = 100, nullable = true, unique = false)
	private String city;
	
	@Column(name = "Street", length = 100, nullable = true, unique = false)
	private String street;
	
	@Column(name = "PostalCode", length = 100, nullable = true, unique = false)
	private String postalCode;
	
	public Customer() {}

	public Customer(String username, String password, String firstname, String lastname, String birthdate, String email,
			String phoneNumber, String paymentMethod, String country, String city, String street, String postalCode) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.paymentMethod = paymentMethod;
		this.country = country;
		this.city = city;
		this.street = street;
		this.postalCode = postalCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	

}
