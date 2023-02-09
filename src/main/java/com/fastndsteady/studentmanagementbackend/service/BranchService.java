package com.fastndsteady.studentmanagementbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastndsteady.studentmanagementbackend.entity.Branch;
import com.fastndsteady.studentmanagementbackend.repository.BranchRepository;

@Service
public class BranchService {
	
	@Autowired
	BranchRepository branchRepo;
	
	public List<Branch> getBranchs() {
		return branchRepo.findAll();
	}

	public Branch addBranch(Branch branch) {
		return branchRepo.save(branch);
	}

	public Branch getBranch(String id) {
		return branchRepo.findById(id).get();
	}

	public String deleteBranch(String id) {
		branchRepo.deleteById(id);
		return "Branch deleted successfully";
	}

	public void updateBranch(Branch branch)
	{
		Branch p=branchRepo.findById(branch.getId());
		branchRepo.remove(p);
		branchRepo.add(branch);
	}
	
}
