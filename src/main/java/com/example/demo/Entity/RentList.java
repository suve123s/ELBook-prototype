package com.example.demo.Entity;

import java.util.Date;

import lombok.Data;

@Data
public class RentList {


	private int rent_id;
	private int user_id;
	private int book_id;
	private int number;
	private int days;
	private Date retern_date;

	public int getRent_id() {
		return rent_id;
	}
	public void setRent_id(int rent_id) {
		this.rent_id = rent_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getRetern_date() {
		return retern_date;
	}
	public void setRetern_date(Date retern_date) {
		this.retern_date = retern_date;
	}


}
