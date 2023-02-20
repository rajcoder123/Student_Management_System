package com.fastndsteady.studentmanagementbackend.exception;

public class IdInUseException extends RuntimeException{
	//Adding id in use exception
    public IdInUseException(String message) {
		super(message);
	}
}
