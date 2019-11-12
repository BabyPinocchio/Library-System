package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Message;
import com.example.demo.entity.Relation;
import com.example.demo.entity.User;
import com.example.demo.repository.RelationRepository;
import com.example.demo.service.RelationService;

@Service
public class RelationServiceImpl implements RelationService {
    @Autowired
    private RelationRepository relationRepository;

    @Override
	public Relation findByUserId(int userId) {
    	Relation relation = relationRepository.findByUserId(userId);
        if(relation == null) {
            return null;
        }
        return relation;
	}
    
    @Override
	public Relation findByRelationId(int relationId) {
    	Relation relation = relationRepository.findByRelationId(relationId);
        if(relation == null) {
            return null;
        }
        return relation;
	}
    
    @Override
    public Message addManagement(Relation relation) {
	    relationRepository.save(relation);
	    return Message.SUCCESS;
    }
    
    @Override
    public Message deleteManagement(Relation relation) {
    	relationRepository.delete(relation);
        return Message.SUCCESS;    // can delete
    }
}