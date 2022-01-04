package com.employee.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionController {
	
	@ExceptionHandler(value=EmployeeNotFoundException.class)
	public ResponseEntity<Object> exception(EmployeeNotFoundException exception)
	{
		
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=EmployeeException.class)
	public ResponseEntity<Object> exception(EmployeeException exception)
	{
		
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=EmployeeTypeNotFoundException.class)
	public ResponseEntity<Object> exception(EmployeeTypeNotFoundException exception)
	{
		
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
