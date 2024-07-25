package com.ReactSpringBootProject.employeemapper;

import com.ReactSpringBootProject.CrudApplication.dto.EmployeeDto;
import com.ReactSpringBootProject.CrudApplication.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto mapToEmployeedDto(Employee employee) {
		
		return new EmployeeDto(employee.getId(), employee.getFirstName() , employee.getLastName() , employee.getEmail() );
				
			
	}
	
public static Employee mapToEmployee(EmployeeDto employeeDto) {
		
		return new Employee(employeeDto.getId(), employeeDto.getFirstName() , employeeDto.getLastName() , employeeDto.getEmail() );
				
	}
}
