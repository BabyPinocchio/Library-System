package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Message register(User user) {
        if(userRepository.findByPhoneNumber(user.getPhoneNumber()) == null) {
            userRepository.save(user);
            return Message.SUCCESS;    // not found, can register
        }
        return Message.FAIL;
    }
    
    @Override
	public Message login(String phoneNumber,String password) {
    	User user = userRepository.findByPhoneNumber(phoneNumber);
        if(user != null && user.getPassword().equals(password)) {
            return Message.SUCCESS;
        } else if(user == null) {
            return Message.NOTFOUND;
        }
        return Message.FAIL;
	}
	
    @Override
	public User findByPhoneNumber(String phoneNumber) {
    	User user = userRepository.findByPhoneNumber(phoneNumber);
        if(user == null) {
            return null;
        }
        return user;
	}
    
    @Override
	public User findByUserName(String userName) {
    	User user = userRepository.findByUserName(userName);
        if(user == null) {
            return null;
        }
        return user;
	}
    
    @Override
	public User findByUserId(int userId) {
    	User user = userRepository.findByUserId(userId);
        if(user == null) {
            return null;
        }
        return user;
	}

}