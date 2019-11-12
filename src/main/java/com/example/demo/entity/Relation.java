package com.example.demo.entity;

import com.example.demo.entity.Book;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

@Entity
public class Relation {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	 	private int relationId;
	 
	 	private int bookId;
	    private int userId;
	    private Date time;
	    private String bookName;
	 	
	    public int getRelationId() {
	        return relationId;
	    }
	 	
	    public void setRelationId(int relationId) {
	        this.relationId = relationId;
	    }
	    
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
	    
	    public int getUserId() {
	        return userId;
	    }
	 	
	    public void setUserId(int userId) {
	        this.userId = userId;
	    }
	    
	    public Date getTime() {
	        return time;
	    }

	    public void setTime(Date time) {
	        this.time = time;
	    }
	    
}
