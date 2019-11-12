package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	 	@Column(name="book_id")
	 	private int bookId;
	 
	 	@Column(name="book_name")
	    private String bookName;
	 	
	    private double price;
	 	private int num;
	 	
	 	public int getBookId() {
	        return bookId;
	    }
	 	
	    public void setBookId(int bookId) {
	        this.bookId = bookId;
	    }
	    
	    public String getBookName() {
	        return bookName;
	    }
	 	
	    public void setBookName(String bookName) {
	        this.bookName = bookName;
	    }
	    
	    public double getPrice() {
	        return price;
	    }
	 	
	    public void setPrice(double price) {
	        this.price = price;
	    }
	    
	    public int getNum() {
	    	return num;
	    }
	    
	    public void setNum(int num) {
	    	this.num = num;
	    }
}
