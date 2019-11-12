package com.example.demo.controller;


import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	ManagerServiceImpl managerServiceImpl;
	
	@RequestMapping(value = "/userSignup",method = RequestMethod.POST)
	public String userSignUp(@RequestParam("phoneNumber") String phoneNumber, @RequestParam("password") String password
            , @RequestParam("userName") String userName, HttpServletRequest req, HttpSession session) {
		 
		User user = userServiceImpl.findByPhoneNumber(phoneNumber);
	    if(user == null) {
	    	User user1 = new User();
	        user1.setPassword(password);
	        user1.setName(userName);
	        user1.setPhoneNumber(phoneNumber);
	        userServiceImpl.register(user1);
	        return "index.jsp";  // register success, then click login button 
	    } else {
	        session.setAttribute("res","Register Failed !");
	        return "userSignup.jsp";    //  return register page, register again
	    }
	 }
	 
	 @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
	    public String login(HttpServletRequest req, HttpSession session) {
	        String phoneNumber = req.getParameter("phoneNumber");
	        String password = req.getParameter("password");
	        Message message = userServiceImpl.login(phoneNumber,password);
	        String res = null;
	        if(message.equals(Message.NOTFOUND)) {
	            res = "Not Found!";
	            session.setAttribute("res",res);
	        } else if(message.equals(Message.FAIL)) {
	            res = "Login Failed!";
	            session.setAttribute("res",res);
	        }else if(message.equals(Message.SUCCESS)) {
	            User user = userServiceImpl.findByPhoneNumber(phoneNumber);
	            session.setAttribute("user",user);
	            return "/bookIndex.jsp";     // login success, enter bookStore
	        }
	        return "userLogin.jsp";    // return login page
	    }
	 
	 
	 @RequestMapping(value = "/managerIndex",method = RequestMethod.POST)
	    public String managerLogin(HttpServletRequest req, HttpSession session) {
	        String managerName = req.getParameter("managerName");
	        String password = req.getParameter("password");
	        Message message = managerServiceImpl.login(managerName,password);
	        String res = null;
	        if(message.equals(Message.NOTFOUND)) {
	            res = "Not Found!";
	            session.setAttribute("res",res);
	        } else if(message.equals(Message.FAIL)) {
	            res = "Login Failed!";
	            session.setAttribute("res",res);
//	            return "managerIndex.jsp";
	        }else if(message.equals(Message.SUCCESS)) {
	            Manager manager = managerServiceImpl.findByManagerName(managerName);
	            session.setAttribute("manager",manager);
	            return "bookManagement.jsp";     // login success, enter manager system
	        }
	        return "managerIndex.jsp";    // return login page
	    }
	 
}
