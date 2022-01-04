package com.employee.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import com.employee.exception.EmployeeNotFoundException;
import com.employee.exception.EmployeeTypeNotFoundException;
import com.employee.model.EmployeeData;
import com.employee.serivce.EmployeeService;

@RestController
@RequestMapping("/Emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService eserv;
	
	@RequestMapping("/getAll")
	public List<EmployeeData> getEmp()
	{
		
		return eserv.GetallEmps();
	}
	@RequestMapping("/getEmp/{id}")
	public Optional<EmployeeData> getById(@PathVariable String id)
	{
		try
		{
		 eserv.getEmpId(id);	
		}
	
		catch(NoSuchElementException e) {
			throw new EmployeeTypeNotFoundException("No Such Employee By This Id Found");
		}
		
		return eserv.getEmpId(id);	
		
	}
	@RequestMapping(method=RequestMethod.POST , value="/add")
	public String addEmp(@RequestBody EmployeeData e)
	{
		eserv.addNewEmp(e);
		return "Employee Added Successfully";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/update/{id}")
	public String updateEmp(@PathVariable String id,@RequestBody EmployeeData e)
	{
		
		eserv.updateEmpData(id, e);
		return " Employe Data Updated ";
		
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/delete/{id}")
	public String deleteEmp(@PathVariable String id)
	{
		try {
			eserv.deleteEmpData(id);
			}
			catch(EmptyResultDataAccessException e)
			{
				throw new EmployeeNotFoundException("Employee Of Given Id Not Found");
			}
		return " Employee Data Deleted ";
		
	}
	


}
