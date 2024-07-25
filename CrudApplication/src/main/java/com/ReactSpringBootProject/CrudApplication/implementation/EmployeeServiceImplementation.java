package com.ReactSpringBootProject.CrudApplication.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReactSpringBootProject.CrudApplication.dto.EmployeeDto;
import com.ReactSpringBootProject.CrudApplication.entity.Employee;
import com.ReactSpringBootProject.CrudApplication.repository.EmployeeRepository;
import com.ReactSpringBootProject.CrudApplication.services.EmployeeService;
import com.ReactSpringBootProject.employeemapper.EmployeeMapper;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		
		Employee savedEmployee = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeedDto(savedEmployee);
	}

}
