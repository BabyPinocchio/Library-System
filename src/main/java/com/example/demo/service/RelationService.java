package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Message;
import  com.example.demo.entity.Relation;

public interface RelationService {
	Message addManagement(Relation relation);
	Relation findByUserId(int userId);
	Relation findByRelationId(int relationId);
	Message deleteManagement(Relation relation);
}