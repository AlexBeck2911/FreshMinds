package de.freshminds.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Delivery")
public class Delivery {

	@Id
	@Column(name = "DeliveryNumber")
	private int deliveryNumber;

	@Column(name = "TransactionNumber")
	private int transactionNumber;

	@Column(name = "Username", length = 128, nullable = true, unique = false)
	private String username;

	@Column(name = "Country", length = 100, nullable = true, unique = false)
	private String country;

	@Column(name = "City", length = 100, nullable = true, unique = false)
	private String city;

	@Column(name = "Street", length = 100, nullable = true, unique = false)
	private String street;

	@Column(name = "PostalCode", length = 100, nullable = true, unique = false)
	private String postalCode;

	@Column(name = "DeliveryDate", length = 128, nullable = true, unique = false)
	private Date deliveryDate;

	public Delivery() {
	}

	public Delivery(int deliveryNumber, int transactionNumber, String username, String country, String city,
			String street, String postalCode, Date deliveryDate) {

		this.deliveryNumber = deliveryNumber;
		this.transactionNumber = transactionNumber;
		this.username = username;
		this.country = country;
		this.city = city;
		this.street = street;
		this.postalCode = postalCode;
		this.deliveryDate = deliveryDate;
	}

	public int getDeliveryNumber() {
		return deliveryNumber;
	}

	public void setDeliveryNumber(int deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}

	public int getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Date getdeliveryDate() {
		return deliveryDate;
	}

	public void setdeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

}
