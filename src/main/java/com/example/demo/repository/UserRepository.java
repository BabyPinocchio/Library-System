package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
    User findByPhoneNumber(String phoneNumber);
    User findByUserId(int userId);
    User findByUserName(String userName);
}
