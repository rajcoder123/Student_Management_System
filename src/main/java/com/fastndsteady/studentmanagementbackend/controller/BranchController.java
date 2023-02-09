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

import com.fastndsteady.studentmanagementbackend.entity.Branch;
import com.fastndsteady.studentmanagementbackend.service.BranchService;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@GetMapping("/branches")
	@CrossOrigin(origins = "*")
	public List<Branch> getBranchs() {
		return branchService.getBranchs();
	}

	@GetMapping("/branches/{id}")
	public Branch getBranchs(@PathVariable String id) {
		return branchService.getBranch(id);
	}

	@PostMapping("/branches")
	public Branch addBranch(@RequestBody Branch branch) {
		return branchService.addBranch(branch);
	}

	@DeleteMapping("/branches/{id}")
	@CrossOrigin(origins = "*")
	public String deleteBranch(@PathVariable String id) {
		return branchService.deleteBranch(id);
	}

	// For Updating Branch
	@PutMapping("/branches")
	public void updateBranch(@RequestBody Branch branch)
	{
	    branchService.updateBranch(branch);
	}

}
