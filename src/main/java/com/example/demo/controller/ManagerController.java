package com.example.demo.controller;

import com.example.demo.entity.*;
//import com.example.demo.entity.*;
import com.example.demo.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

@Controller
public class ManagerController {
	@Autowired
	ManagerServiceImpl managerServiceImpl;
	
	@Autowired
	BookServiceImpl bookServiceImpl;
	
	// 增加一本数据库中不存在的书
	@RequestMapping(value = "/bookManagement/addBook",method = RequestMethod.POST)
	public String addBook(@RequestParam("bookName") String bookName, @RequestParam("price") double price, 
			@RequestParam("num") int num, HttpServletRequest req, HttpSession session) {
		Book book = bookServiceImpl.findByBookName(bookName);
	    if(book == null) {
	    	Book book1 = new Book();
	        book1.setBookName(bookName);
	        book1.setPrice(price);
	        book1.setNum(num);
	        bookServiceImpl.addManagement(book1);
	    } else {
	        session.setAttribute("res","Add Book Failed !");
	    }
	    return "/bookManagement.jsp"; 
	}
	
	// 增加或减少书的数量
	@RequestMapping(value = "/bookManagement/updateBook",method = RequestMethod.POST)
	public String updateBook(@RequestParam("bookName") String bookName, @RequestParam("number") int number,
			HttpServletRequest req, HttpSession session) {
	
		Book book = bookServiceImpl.findByBookName(bookName);
		if(book != null) {
			int bookId = book.getBookId();
			bookServiceImpl.updateNum(bookId,number);
		}else {
			session.setAttribute("res","Update Book Failed !");
		}
		 return "/bookManagement.jsp";
	}
	
	// 删除该书
	@RequestMapping(value = "/bookManagement/deleteBook",method = RequestMethod.POST)
	public String deleteBook(@RequestParam("bookName") String bookName,
			HttpServletRequest req, HttpSession session) {
		Book book = bookServiceImpl.findByBookName(bookName);
		if(book != null) {
			bookServiceImpl.deleteManagement(book);
		}else {
			session.setAttribute("res","Delete Book Failed !");
		}
		 return "/bookManagement.jsp";
	}
}
