package de.freshminds.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction {
	
	@Id
	@Column(name = "TransactionNumber")
	private int transactionNumber;
	
	@Column(name = "Username", length = 128, nullable = true, unique = false)
	private String username;
	
	@Column(name = "ArticleNumber", length = 128, nullable = true, unique = false)
	private int articleNumber;
	
	@Column(name = "Amount", length = 128, nullable = true, unique = false)
	private int amount;
	
	@Column(name = "Price", length = 128, nullable = true, unique = false)
	private int price;
	
	@Column(name = "PaymentMethod", length = 128, nullable = true, unique = false)
	private String paymentMethod;
	
	@Column(name = "Timestamp", length = 128, nullable = true, unique = false)
	private Date timestamp;
	
	public Transaction() {}

	public Transaction(int transactionNumber, String username, int articleNumber, int amount, int price, String paymentMethod, Date timestamp) {
		this.transactionNumber = transactionNumber;
		this.username = username;
		this.articleNumber = articleNumber;
		this.amount = amount;
		this.price = price;
		this.paymentMethod = paymentMethod;
		this.timestamp = timestamp;
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

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
