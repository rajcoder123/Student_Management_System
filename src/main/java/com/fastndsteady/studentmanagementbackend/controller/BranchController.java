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

import com.fastndsteady.studentmanagementbackend.entity.Branch;
import com.fastndsteady.studentmanagementbackend.service.BranchService;
import com.fastndsteady.studentmanagementbackend.exception.BranchNotFoundException;
import com.fastndsteady.studentmanagementbackend.exception.EmptyInputException;
import com.fastndsteady.studentmanagementbackend.exception.IdInUseException;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@GetMapping("/branches")
	@CrossOrigin(origins = "*")
	public List<Branch> getBranchs() {
		List<Branch> branch = (List<Branch>) branchService.getBranchs();
		if (branch.isEmpty()) {
			throw new BranchNotFoundException("Branch not found.");
		}
		return branchService.getBranchs();
	}

	@GetMapping("/branches/{id}")
	@CrossOrigin(origins = "*")
	public Branch getBranchs(@PathVariable String id) {
		return branchService.getBranch(id);
	}

	@PostMapping("/branches")
	@CrossOrigin(origins = "*")
	public Branch addBranch(@RequestBody Branch branch) {
		Branch checkIfBranchWithIdExist = branchService.getBranch(branch.getId());
		if (checkIfBranchWithIdExist != null) {
			throw new IdInUseException("Branch already exist.");
		}
		else {
			branchService.addBranch(branch);
			return branch;
		}
	}

	@DeleteMapping("/branches/{id}")
	@CrossOrigin(origins = "*")
	public String deleteBranch(@PathVariable String id) {
		if(id==null)
		{
			throw new EmptyInputException("You need to provide ID of Branch to be deleted. ID can not be Null.");
		}
		Branch checkIfBranchWithIdExist = branchService.getBranch(id);
		if (checkIfBranchWithIdExist==null) {
			throw new BranchNotFoundException(
					"Branch can not be deleted because branch with id: " + id + " does not exist.");
		}
		return branchService.deleteBranch(id);
	}
	@PutMapping("/branches/{id}")
	@CrossOrigin(origins = "*")
	public void updateBranch(@PathVariable String id,@RequestBody Branch branch)
	{
	    branchService.updateBranch(branch);
	}

}
