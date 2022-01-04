package com.employee.dao;
import com.employee.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
@Repository("edao")
public interface EmployeeDao extends JpaRepository<EmployeeData,String> {


}
