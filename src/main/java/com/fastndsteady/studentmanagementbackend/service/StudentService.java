package com.fastndsteady.studentmanagementbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastndsteady.studentmanagementbackend.entity.Student;
import com.fastndsteady.studentmanagementbackend.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;

	public List<Student> getStudents() {
		return studentRepo.findAll();
	}

	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}

	public Student getStudent(String id) {
		return studentRepo.findById(id).get();
	}

	public String deleteStudent(String id) {
		studentRepo.deleteById(id);
		return "Student deleted successfully";
	}
	public void updateStudent(Student student)
	{
		Student p=studentRepo.findById(student.getId());
		studentRepo.remove(p);
		studentRepo.add(student);
	}
}
