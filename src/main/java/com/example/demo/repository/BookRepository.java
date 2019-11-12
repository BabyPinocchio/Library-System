package com.example.demo.repository;

import com.example.demo.entity.*;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer>{
	 Book findByBookName(String bookName);
	 Book findByBookId(int bookId);
	 Book deleteByBookId(int bookId);
//	    int updateNum(@Param("change") int change,@Param("bookId") int bookId);
}
