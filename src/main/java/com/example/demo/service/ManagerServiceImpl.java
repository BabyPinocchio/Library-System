package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.*;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{
	 @Autowired
	    private ManagerRepository managerRepository;
//	    private BookRepository bookRepository;
	 
	    @Override
	    public Message login(String managerName, String password) {
	    	Manager manager = managerRepository.findByManagerName(managerName);
	        if(manager != null && manager.getPassword().equals(password)) {
	            return Message.SUCCESS;
	        } else if(manager == null) {
	            return Message.NOTFOUND;
	        }
	        return Message.FAIL;
	    }
	    
	    @Override
	    public Manager findByManagerName(String managerName) {
	    	Manager manager = managerRepository.findByManagerName(managerName);
	        if(manager == null) {
	            return null;
	        }
	        return manager;
	    }
}
