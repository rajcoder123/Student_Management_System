package com.fastndsteady.studentmanagementbackend.exception;

public class StudentNotFoundException extends RuntimeException{
	public StudentNotFoundException(String message) {
		super(message);
	}
}
