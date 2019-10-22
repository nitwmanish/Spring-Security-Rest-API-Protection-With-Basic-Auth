package com.oracle.mcv.webapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	private String isbn;
	private String name;
	private String discription;

	public Book() {
		super();
	}

	public Book(String isbn, String name, String discription) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.discription = discription;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

}
