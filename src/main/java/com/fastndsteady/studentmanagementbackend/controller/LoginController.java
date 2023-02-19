package com.fastndsteady.studentmanagementbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastndsteady.studentmanagementbackend.entity.User;
import com.fastndsteady.studentmanagementbackend.service.AuthenticationService;

@RestController
public class LoginController {
	@Autowired
    AuthenticationService service;
	
	@PostMapping("/admin/login")
	public String adminAuthentication(@RequestBody User user)
	{
		if(service.adminAuthentication(user))
			return "Admin loggged in Successfully";
		return "Please Enter Correct Details";
		
	}
	
	@PostMapping("/student/login")
	public String studentAuthentication(@RequestBody User user)
	{
		if(service.studentAuthentication(user))
			return "Student Logged in Successfully";
		return "Please Enter Correct Details";
		
	}
	
	@PostMapping("/student/signup")
	public String studentSignup(@RequestBody User user)
	{  
		if(service.findByName(user.getUserName()))
	{     return "Please Enter New User";}
	else {
		service.insert(user);
		return "Student Signed up Successfully";
	}
		
	}
	
	
	
	
	

}
