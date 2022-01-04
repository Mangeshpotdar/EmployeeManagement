package com.employee.serivce;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.dao.EmployeeDao;
import com.employee.model.EmployeeData;

@Service("eserv")
public class EmployeeService {
	@Autowired
	private EmployeeDao edao;
	
	public List<EmployeeData>GetallEmps()
	{	
		List<EmployeeData> emp=new ArrayList<>();
		edao.findAll().forEach(emp::add);	
		return edao.findAll();
	}

	public Optional<EmployeeData> getEmpId(String id) {
		return edao.findById(id) ;
	}

	public void addNewEmp(EmployeeData e) {
		edao.save(e);	
	}

	public void updateEmpData(String id,EmployeeData e) {
		edao.save(e);
	}

	public void deleteEmpData(String id) {
		edao.deleteById(id);
	}
	
}
