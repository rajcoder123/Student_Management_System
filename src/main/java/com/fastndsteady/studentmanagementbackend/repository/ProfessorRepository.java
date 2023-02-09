package com.fastndsteady.studentmanagementbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fastndsteady.studentmanagementbackend.entity.Professor;

@Repository
public interface ProfessorRepository extends MongoRepository<Professor, String> {

}
