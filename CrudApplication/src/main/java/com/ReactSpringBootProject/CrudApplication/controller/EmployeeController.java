package com.ReactSpringBootProject.CrudApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ReactSpringBootProject.CrudApplication.dto.EmployeeDto;
import com.ReactSpringBootProject.CrudApplication.services.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	
	
	//build add employee Rest API
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	
	//Get Employee Rest API
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") long employeeid ){
		
		EmployeeDto employeeFetched = employeeService.getEmployeeById(employeeid);
		
		return new ResponseEntity<>(employeeFetched, HttpStatus.OK);
	}
}
