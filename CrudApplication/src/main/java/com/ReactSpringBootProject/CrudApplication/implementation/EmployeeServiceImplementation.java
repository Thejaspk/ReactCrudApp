package com.ReactSpringBootProject.CrudApplication.implementation;


import java.util.ArrayList;
import java.util.List;

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

}
	
	
	@Override
	public List<EmployeeDto> getAllEmployee() {
		
	
		 List<Employee>  employeeList = employeeRepository.findAll();
		 List<EmployeeDto>  employeeDtoList = new ArrayList<>() ;
		 
		
		 for (Employee employee : employeeList) {
		        EmployeeDto dto = convertToDto(employee);
		        employeeDtoList.add(dto);
		    }
		 
		 return  employeeDtoList ;
		 
}


	private EmployeeDto convertToDto(Employee employee) {
		
		EmployeeDto dto = new EmployeeDto();
		
		dto.setId(employee.getId());
		dto.setFirstName(employee.getFirstName());
		dto.setLastName(employee.getLastName());
		dto.setEmail(employee.getEmail());
		return dto;
		
	}
	
	@Override
	public EmployeeDto updateEmployee(Long employeeId , EmployeeDto employeeDto) {
		
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id :" + employeeId));
		
	
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		Employee employeeUpdated = employeeRepository.save(employee);
		
		EmployeeDto EmployeeDtoUpdated = EmployeeMapper.mapToEmployeedDto(employeeUpdated);
		
		return EmployeeDtoUpdated;
		
	}
	
	
	
	@Override
	public void deleteEmployee(Long Employeeid) {

		try {
		employeeRepository.deleteById(Employeeid);

	}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	
	}}
