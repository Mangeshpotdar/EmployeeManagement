package com.employee.exception;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException() {}
	public EmployeeNotFoundException(String message)
	{
		super (message);
	}
	

}
