package com.ReactSpringBootProject.CrudApplication.services;

import java.util.List;

import com.ReactSpringBootProject.CrudApplication.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long Employeeid);
	
	List<EmployeeDto> getAllEmployee();
	
	

	EmployeeDto updateEmployee(Long employeeId , EmployeeDto employeeDto);
	
	void deleteEmployee(Long id);

}
