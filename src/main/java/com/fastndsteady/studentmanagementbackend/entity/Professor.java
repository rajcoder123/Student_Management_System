package com.fastndsteady.studentmanagementbackend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("professors")
public class Professor {
	@Id
	private String id;
	private String name;
	private String branchName;
	private String phoneNumber;
	private String emailId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", branchName=" + branchName + ", phoneNumber=" + phoneNumber
				+ ", emailId=" + emailId + "]";
	}
	public Professor(String id, String name, String branchName, String phoneNumber, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.branchName = branchName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}
	public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
