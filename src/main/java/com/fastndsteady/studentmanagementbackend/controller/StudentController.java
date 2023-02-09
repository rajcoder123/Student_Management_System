package com.fastndsteady.studentmanagementbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastndsteady.studentmanagementbackend.entity.Student;
import com.fastndsteady.studentmanagementbackend.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/students")
	@CrossOrigin(origins = "*")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@GetMapping("/students/{id}")
	public Student getStudents(@PathVariable String id) {
		return studentService.getStudent(id);
	}

	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@DeleteMapping("/students/{id}")
	@CrossOrigin(origins = "*")
	public String deleteStudent(@PathVariable String id) {
		return studentService.deleteStudent(id);
	}
	//for updating Students
   @PutMapping("/students")
	public void updateStudent(@RequestBody Student student)
	{
	      studentService.updateStudent(student);
	}

}
