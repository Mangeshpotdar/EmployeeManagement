package com.employee.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeData {

	@Id
	private String Empid;	
	private String EmpName;
	private String EmpMail;
	private long EmpContact;
	private String EmpRole;
	
	
	public EmployeeData() {
		
	}
	public EmployeeData(String empid, String empName, String empMail, long empContact, String empRole) {
		super();
		Empid = empid;
		EmpName = empName;
		EmpMail = empMail;
		EmpContact = empContact;
		EmpRole = empRole;
	}
	public String getEmpid() {
		return Empid;
	}
	public void setEmpid(String empid) {
		Empid = empid;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmpMail() {
		return EmpMail;
	}
	public void setEmpMail(String empMail) {
		EmpMail = empMail;
	}
	public long getEmpContact() {
		return EmpContact;
	}
	public void setEmpContact(long empContact) {
		EmpContact = empContact;
	}
	public String getEmpRole() {
		return EmpRole;
	}
	public void setEmpRole(String empRole) {
		EmpRole = empRole;
	}
	@Override
	public String toString() {
		return "EmployeeData [Empid=" + Empid + ", EmpName=" + EmpName + ", EmpMail=" + EmpMail + ", EmpContact="
				+ EmpContact + ", EmpRole=" + EmpRole + "]";
	}
	
	
	
}
