package de.freshminds.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {

	private int categoryNumber;
	private String categoryDesignation;

	public Category() {
	}

	@Id
	@Column(name = "CategoryNumber")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	@Column(name = "Designation")
	public String getCategoryDesignation() {
		return categoryDesignation;
	}

	public void setCategoryDesignation(String categoryDesignation) {
		this.categoryDesignation = categoryDesignation;
	}

}
