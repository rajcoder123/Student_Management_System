package com.fastndsteady.studentmanagementbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastndsteady.studentmanagementbackend.entity.Student;
import com.fastndsteady.studentmanagementbackend.exception.EmptyInputException;
import com.fastndsteady.studentmanagementbackend.exception.IdInUseException;
import com.fastndsteady.studentmanagementbackend.exception.StudentNotFoundException;
import com.fastndsteady.studentmanagementbackend.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/students")
	@CrossOrigin(origins = "*")
	public List<Student> getStudents() {
		List<Student> students = (List<Student>) studentService.getStudents();
		if (students.isEmpty()) {
			throw new StudentNotFoundException("Students not found.");
		}
		return studentService.getStudents();
	}

	@GetMapping("/students/{id}")
	@CrossOrigin(origins = "*")
	public Student getStudents(@PathVariable String id) {
		return studentService.getStudent(id);
	}

	@PostMapping("/students")
	@CrossOrigin(origins = "*")
	public Student addStudent(@RequestBody Student student) {
		Student checkIfStudentWithIdExist = studentService.getStudent(student.getId());
		if (checkIfStudentWithIdExist != null) {
			throw new IdInUseException("Student already exist.");
		}
		else {
			studentService.addStudent(student);
			return student;
		}
	}

	@DeleteMapping("/students/{id}")
	@CrossOrigin(origins = "*")
	public String deleteStudent(@PathVariable String id) {
		if(id==null) {
			throw new EmptyInputException("You need to provide ID of to be deleted. ID can not be Null.");
		}
		Student checkIfProjecttWithIdExist = studentService.getStudent(id);
		if (checkIfProjecttWithIdExist==null) {
			throw new StudentNotFoundException(
					"Student can not be deleted because student with id: " + id + " does not exist.");
		}
		return studentService.deleteStudent(id);
	}
   @PutMapping("/students/{id}")
   @CrossOrigin(origins = "*")
	public void updateStudent(@PathVariable String id,@RequestBody Student student)
	{
	      studentService.updateStudent(student);
	}

}
