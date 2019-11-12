package com.example.demo.service;

import  com.example.demo.entity.*;

public interface ManagerService {
	Message login(String managerName, String password);
	Manager findByManagerName(String managerName);
}
