package com.example.demo.service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import  com.example.demo.entity.*;

@Transactional
public interface BookService {
	Message addManagement(Book book);
	Message deleteManagement(Book book);
	Book findByBookName(String bookName);
	Book findByBookId(int bookId);
	 @Transactional
	    @Modifying
	    @Query(value = "update Book b set b.bum = :change+b.num where b.bookId = :bookId")
	    int updateNum(@Param("change") int change,@Param("bookId") int bookId);
}
