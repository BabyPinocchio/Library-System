package com.example.demo.service;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Book;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	 @Autowired
	 BookRepository bookRepository;
	 
	 @PersistenceContext
	 private EntityManager em;
	 
//	 @Override
//	 public Message search(Book book) {
//		 if(bookRepository.findByBookName(book.getBookName()) == null) {
//	            return Message.FAIL;    // not found
//	        }
//	        return Message.SUCCESS;
//	 }
	 @Override
	    public Message addManagement(Book book) {
	        if(bookRepository.findByBookName(book.getBookName()) == null) {
	            bookRepository.save(book);
	            return Message.SUCCESS;    // not found, can add
	        }
	        return Message.FAIL;
	    }
	 
	 @Override
	    public Message deleteManagement(Book book) {
	        if(bookRepository.findByBookName(book.getBookName()) != null) {
	            bookRepository.delete(book);
	            return Message.SUCCESS;    // can delete
	        }
	        return Message.FAIL;
	    }
	 
	 @Override
	 public Book findByBookName(String bookName) {
		 Book book = bookRepository.findByBookName(bookName);
	     if(book == null) {
	    	 return null;
	     }
	     return book;
	 }
	 
	 @Override
	 public Book findByBookId(int bookId) {
		 Book book = bookRepository.findByBookId(bookId);
	     if(book == null) {
	    	 return null;
	     }
	     return book;
	 }
	 
	 @Override
	 public int updateNum(int bookId,int change) {
		 String jpql = "update Book b set b.num = :change+b.num where b.bookId = :bookId";
		 Query query = em.createQuery(jpql);
		 query.setParameter("change",change).setParameter("bookId",bookId);
		 return query.executeUpdate();
	 }
}
