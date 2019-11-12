package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/")
	 String index(){
        return "index.jsp";
    }
	
	@RequestMapping("/userSignup")
    public String signUp() { 
		return "userSignup.jsp"; 
	}

	 @RequestMapping("/userLogin")
	 public String login() {
		 return "userLogin.jsp";
	 }

	 @RequestMapping("/managerIndex")
	 public String managerIndex() {
		 return "managerIndex.jsp";
	 }
	 
	 @RequestMapping("/bookStore")
	 public String bookStore() {
		 return "bookStore.jsp";
	 }
	 
	 @RequestMapping("/bookManagement")
	 public String bookManagement() {
		 return "bookManagement.jsp";
	 }
	 
	 @RequestMapping("/bookIndex")
	 public String bookIndex() {
		 return "bookIndex.jsp";
	 }
	 
	 @RequestMapping("/borrowRecord")
	 public String borrowRecord() {
		 return "borrowrecord.jsp";
	 }
	 
	 @RequestMapping("/bookSearch")
	 public String bookSearch() {
		 return "bookSearch.jsp";
	 }
}
