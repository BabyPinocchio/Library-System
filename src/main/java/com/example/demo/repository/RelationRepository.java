package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationRepository extends CrudRepository<Relation,Integer>{
	 Relation findByRelationId(int relationId);
	 Relation findByUserId(int userId);
	 Relation findByBookId(int bookId);
	 Relation deleteByUserId(int userId);
}