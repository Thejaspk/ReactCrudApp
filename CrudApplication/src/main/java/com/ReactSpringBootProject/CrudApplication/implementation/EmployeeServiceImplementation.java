package com.ReactSpringBootProject.CrudApplication.implementation;


import org.springframework.stereotype.Service;

import com.ReactSpringBootProject.CrudApplication.dto.EmployeeDto;
import com.ReactSpringBootProject.CrudApplication.entity.Employee;
import com.ReactSpringBootProject.CrudApplication.exception.ResourceNotFoundException;
import com.ReactSpringBootProject.CrudApplication.repository.EmployeeRepository;
import com.ReactSpringBootProject.CrudApplication.services.EmployeeService;
import com.ReactSpringBootProject.employeemapper.EmployeeMapper;
import com.google.gson.Gson;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
	
	
	private EmployeeRepository employeeRepository;
	
	 private final Gson gson = new Gson();
	
	public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		
		Employee savedEmployee = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeedDto(savedEmployee);
	}





	@Override
	public EmployeeDto getEmployeeById(Long Employeeid) {
		
		try {
			Employee employee = employeeRepository.findById(Employeeid).orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id :" + Employeeid));
		
		
		
		return EmployeeMapper.mapToEmployeedDto(employee);
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;

}}
