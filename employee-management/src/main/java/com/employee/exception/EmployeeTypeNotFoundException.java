package com.employee.exception;

@SuppressWarnings("serial")
public class EmployeeTypeNotFoundException extends RuntimeException{
	public EmployeeTypeNotFoundException() {}
	public EmployeeTypeNotFoundException(String message) {
		super(message);
	}

}
