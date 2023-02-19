package com.fastndsteady.studentmanagementbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastndsteady.studentmanagementbackend.entity.User;
import com.fastndsteady.studentmanagementbackend.repository.UserRepository;

@Service
public class AuthenticationService {
	
	@Autowired
	UserRepository userRepo;
	

	public boolean adminAuthentication(User user)
	{
		boolean isValid=user.getUserName().equals("Ankit Rajput");
		boolean isValidPassword=user.getPassword().equals("12345");
		return isValid && isValidPassword;
	}
	
	public boolean findByName(String userName)
	{
		User user=userRepo.findByUserName(userName);
		if(user !=null)
		  return true;
		else
			return false;
	}
	public boolean findByPassword(String password)
	{
		User user=userRepo.findByPassword(password);
		if(user !=null)
		  return true;
		else
			return false;
	}
	
	public boolean studentAuthentication(User user)
	{  Boolean isValid = false;
	   Boolean isValidPassword = false;
		if(findByName(user.getUserName())&& findByPassword(user.getPassword()))
		      {isValid=true;
		      isValidPassword=true;
		      }
		
		return (isValid && isValidPassword);
	}

	
	public void insert(User user)
	{
		userRepo.save(user);
	}
}
