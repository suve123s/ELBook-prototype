package com.example.demo.Entity;

import lombok.Data;

@Data
public class BookList {


	private int book_id;
	private String book_name;
	private String genre;
	private int stock;
	private int rent;
	
	public int getBook_id() {
		return book_id;
	}public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	
	public String getBook_name() {
		return book_name;
	}public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	
	public String getGenre() {
		return genre;
	}public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public int getStock() {
		return stock;
	}public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getRent() {
		return rent;
	}public void setRent(int rent) {
		this.rent = rent;
	}
	
}


