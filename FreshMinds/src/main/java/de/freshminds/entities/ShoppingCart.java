package de.freshminds.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ShoppingCart")
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int col;
		
	@Column(name = "Username", length = 128, nullable = true, unique = false)
	private String username;
	
	@Column(name = "ArticleNumber", length = 128, nullable = true, unique = false)
	private int articleNumber;
	
	@Column(name = "Amount", length = 128, nullable = true, unique = false)
	private int amount;
	
	@Column(name = "Price", length = 128, nullable = true, unique = false)
	private double price;
	
	public ShoppingCart(String username, int articleNumber, int amount, double price, int col) {
		this.col = col;
		this.username = username;
		this.articleNumber = articleNumber;
		this.amount = amount;
		this.price = price;
	}
	
	public ShoppingCart() {}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}
