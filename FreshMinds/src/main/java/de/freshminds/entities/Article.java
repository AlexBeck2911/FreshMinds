package de.freshminds.entities;

import javax.persistence.*;

@Entity
@Table(name = "Article")
public class Article {

	private int articleNumber;
	private String articleName;
	private double articlePrice;
	private String articleOrigin;
	private int articleCategory;

	public Article() {
	}

	@Id
	@Column(name = "ArticleNumber")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
