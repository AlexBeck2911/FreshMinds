package de.freshminds.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stock")
public class Stock {

	@Id
	@Column(name = "ArticleNumber")
	private int articleNumber;
	
	@Column(name = "Amount", length = 128, nullable = true, unique = false)
	private int articleAmount;
	
	public Stock() {}

	public Stock(int articleNumber, int articleAmount) {
		this.articleNumber = articleNumber;
		this.articleAmount = articleAmount;
	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public int getArticleAmount() {
		return articleAmount;
	}

	public void setArticleAmount(int articleAmount) {
		this.articleAmount = articleAmount;
	}

}
