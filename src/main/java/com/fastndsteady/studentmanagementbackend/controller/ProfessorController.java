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
import com.fastndsteady.studentmanagementbackend.exception.EmptyInputException;
import com.fastndsteady.studentmanagementbackend.exception.IdInUseException;
import com.fastndsteady.studentmanagementbackend.exception.ProfessorNotFoundException;
import com.fastndsteady.studentmanagementbackend.service.ProfessorService;


@RestController
public class ProfessorController {

	@Autowired
	ProfessorService professorService;

	@GetMapping("/professors")
	@CrossOrigin(origins = "*")
	public List<Professor> getProfessors() {
		List<Professor> professor = (List<Professor>) professorService.getProfessors();
		if (professor.isEmpty()) {
			throw new ProfessorNotFoundException("Professor not found.");
		}
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
		Professor checkIfProfessorWithIdExist = professorService.getProfessor(professor.getId());
		if (checkIfProfessorWithIdExist != null) {
			throw new IdInUseException("Professor already exist.");
		}
		else {
			professorService.addProfessor(professor);
			return professor;
		}
	}

	@DeleteMapping("/professors/{id}")
	@CrossOrigin(origins = "*")
	public String deleteProfessor(@PathVariable String id) {
		if(id==null)
		{
			throw new EmptyInputException("You need to provide ID of professor to be deleted. ID can not be 0.");
		}
		Professor checkIfProfessorWithIdExist = professorService.getProfessor(id);
		if (checkIfProfessorWithIdExist==null) {
			throw new ProfessorNotFoundException(
				"Professor can not be deleted because project with id: " + id + " does not exist.");
		}
		return professorService.deleteProfessor(id);
	}
  @PutMapping("/professors/{id}")
  @CrossOrigin(origins = "*")
	public void updateProfessor(@PathVariable String id,@RequestBody Professor professor)
	{
	    professorService.updateProfessor(professor);
	}
}
