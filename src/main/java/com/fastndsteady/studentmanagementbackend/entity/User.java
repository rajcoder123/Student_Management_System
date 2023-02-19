package com.fastndsteady.studentmanagementbackend.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import nonapi.io.github.classgraph.json.Id;
@Document("SignupInfo")
public class User {
	@Id
	private String userName;
	private String password;
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
	
	

}
