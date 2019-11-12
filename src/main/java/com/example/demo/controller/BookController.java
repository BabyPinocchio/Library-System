package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.example.demo.repository.*;

import antlr.collections.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BookController {
	@Autowired
	BookServiceImpl bookServiceImpl;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	UserServiceImpl userServiceImpl;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RelationServiceImpl relationServiceImpl;
	@Autowired
	RelationRepository relationRepository;
	
	 @RequestMapping(value = "/bookStore",method = RequestMethod.POST)
	 public String showAllBooks(HttpServletRequest req, HttpSession session) {
		 ArrayList<Book> arraylist = (ArrayList<Book>) bookRepository.findAll();
		 session.setAttribute("books", arraylist);
		 return "bookStore.jsp";
	 }
	 
	 @RequestMapping(value = "/bookStore/borrowBook",method = RequestMethod.POST)
	 public String borrowBooks(HttpServletRequest req, HttpSession session) {
		 int bookId = Integer.parseInt(req.getParameter("bookId"));
		 Book book = bookServiceImpl.findByBookId(bookId);
		 // System.out.println("Book Name: " + book.getBookId());
		 if(book != null) {
				bookServiceImpl.updateNum(bookId, -1);
				String bookName = book.getBookName();
				
				User user = (User) session.getAttribute("user");
				Relation relation = new Relation();
				relation.setBookName(bookName);
				relation.setBookId(book.getBookId());
				relation.setUserId(user.getUserId());
				Date date = new Date();
				relation.setTime(date);
				relationServiceImpl.addManagement(relation);
			}else {
				session.setAttribute("res","Borrow Book Failed !");
			}
		 return "Success";
	 }
	 
	 @RequestMapping(value = "/borrowRecord/returnBook",method = RequestMethod.POST)
	 public String returnBooks(HttpServletRequest req, HttpSession session) {
		 int relationId = Integer.parseInt(req.getParameter("relationId"));
		 Relation relation = relationServiceImpl.findByRelationId(relationId);
		 if(relation != null) {
			 	int bookId = relation.getBookId();
				bookServiceImpl.updateNum(bookId,1);
				relationServiceImpl.deleteManagement(relation);
			}else {
				session.setAttribute("res","Borrow Book Failed !");
			}
		 return "Success";
	 }
	 
	 @RequestMapping(value = "/borrowRecord",method = RequestMethod.POST)
	 public String borrowRecord(HttpServletRequest req, HttpSession session) {
		 User user = (User) session.getAttribute("user");
		 int ID = user.getUserId();
		 ArrayList<Relation> arraylist = (ArrayList<Relation>) relationRepository.findAll();
		 ArrayList<Relation> result = new ArrayList<Relation>();
		 if(arraylist!=null) {
             for(Relation content:arraylist) {
            	 if(content.getUserId()==ID) {
            		 result.add(content);
            	 }
             }
		 }
		 session.setAttribute("result", result);
		 return "/borrowrecord.jsp";
	 }
	 
	 @RequestMapping(value = "/bookStore/bookSearch",method = RequestMethod.POST)
	 public String bookSearch(@RequestParam("bookName") String bookName,HttpServletRequest req, HttpSession session) {
		 Book book = bookRepository.findByBookName(bookName);
		 if(book!=null) {
			 session.setAttribute("book", book);
		 }
		 return "bookSearch.jsp";
	 }
}
