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

import com.fastndsteady.studentmanagementbackend.entity.Professor;
import com.fastndsteady.studentmanagementbackend.service.ProfessorService;

@RestController
public class ProfessorController {

	@Autowired
	ProfessorService professorService;

	@GetMapping("/professors")
	@CrossOrigin(origins = "*")
	public List<Professor> getProfessors() {
		return professorService.getProfessors();
	}

	@GetMapping("/professors/{id}")
	@CrossOrigin(origins = "*")
	public Professor getProfessors(@PathVariable String id) {
		return professorService.getProfessor(id);
	}

	@PostMapping("/professors")
	@CrossOrigin(origins = "*")
	public Professor addProfessor(@RequestBody Professor professor) {
		return professorService.addProfessor(professor);
	}

	@DeleteMapping("/professors/{id}")
	@CrossOrigin(origins = "*")
	public String deleteProfessor(@PathVariable String id) {
		return professorService.deleteProfessor(id);
	}
  @PutMapping("/professors/{id}")
  @CrossOrigin(origins = "*")
	public void updateProfessor(@PathVariable String id,@RequestBody Professor professor)
	{
	    professorService.updateProfessor(professor);
	}
}
