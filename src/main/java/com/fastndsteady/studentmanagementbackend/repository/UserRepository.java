package com.fastndsteady.studentmanagementbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fastndsteady.studentmanagementbackend.entity.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	User findByUserName(String userName);
	User findByPassword(String password);

}
