package com.fastndsteady.studentmanagementbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fastndsteady.studentmanagementbackend.entity.Branch;

@Repository
public interface BranchRepository extends MongoRepository<Branch, String>{

}
