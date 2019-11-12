package com.example.demo.repository;
import com.example.demo.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<Manager,Integer>{
	Manager findByManagerName(String managerName);
}
