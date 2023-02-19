package com.fastndsteady.studentmanagementbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fastndsteady.studentmanagementbackend.entity.Student;
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

}
