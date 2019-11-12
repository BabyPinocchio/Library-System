package com.example.demo.service;

import  com.example.demo.entity.User;
import  com.example.demo.entity.Message;

public interface UserService {
	Message register(User user);
	Message login(String phoneNumber, String password);
	User findByPhoneNumber(String phoneNumber);
	User findByUserName(String userName);
	User findByUserId(int userId);
}
