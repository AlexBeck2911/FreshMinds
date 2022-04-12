package de.freshminds.entities;

import javax.persistence.*;

@Entity
@Table(name = "Article")
public class Article {

	@Id
	@Column(name = "ArticleNumber", length = 128, nullable = true, unique = true)
	private int articleNumber;
	
	@Column(name = "ArticleName", length = 128, nullable = true, unique = false)
	private String articleName;
	
	@Column(name = "ArticlePrice", precision = 10, scale = 2)
	private double articlePrice;
	
	@Column(name = "ArticleOrigin", length = 3, nullable = true, unique = false)
	private String articleOrigin;
	
	@Column(name = "ArticleCategory", precision = 10, scale = 2)
	private int articleCategory;

	public Article() {}
	
	public Article(int articleNumber, String articleName, double articlePrice, String articleOrigin, int articleCategory) {
		this.articleNumber = articleNumber;
		this.articleName = articleName;
		this.articlePrice = articlePrice;
		this.articleOrigin = articleOrigin;
		this.articleCategory = articleCategory;		
	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public double getArticlePrice() {
		return articlePrice;
	}

	public void setArticlePrice(double articlePrice) {
		this.articlePrice = articlePrice;
	}

	public String getArticleOrigin() {
		return articleOrigin;
	}

	public void setArticleOrigin(String articleOrigin) {
		this.articleOrigin = articleOrigin;
	}

	public int getArticleCategory() {
		return articleCategory;
	}

	public void setArticleCategory(int articleCategory) {
		this.articleCategory = articleCategory;
	}

}
