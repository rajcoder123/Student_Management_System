package com.fastndsteady.studentmanagementbackend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("students")
public class Student {
	@Id
	private String id;
	private String name;
	private String branchName;
	private String emailId;
	private Double cgpa;
	private String phoneNumber;
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", branchName=" + branchName + ", emailId=" + emailId
				+ ", cgpa=" + cgpa + ", phoneNumber=" + phoneNumber + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String id, String name, String branchName, String emailId, Double cgpa, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.branchName = branchName;
		this.emailId = emailId;
		this.cgpa = cgpa;
		this.phoneNumber = phoneNumber;
	}
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Double getCgpa() {
		return cgpa;
	}
	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
