package com.interview.demo.dao;

import com.interview.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UserDao extends MongoRepository<User,String> {
}
