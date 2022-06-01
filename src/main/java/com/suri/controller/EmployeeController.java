package com.suri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suri.entity.Employee;
import com.suri.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/register")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
		
		try {
			//use service
			String result = employeeService.createEmployee(employee);
			return new ResponseEntity<>(result,HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in Employee Register",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> displayEmployee(){
		
		try {
			//use service
			List<Employee> list = employeeService.fetchAllEmployee();
			return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in Display Employee",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findEmployeeById(@PathVariable Long id){
		try {
			//use service
			Employee employee = employeeService.fetechEmployeeById(id);
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
			
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
		
		try {
			String updateEmployee = employeeService.updateEmployeeDetails(employee);
			return new ResponseEntity<String>(updateEmployee,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping("/emp/{id}")
	public ResponseEntity<String> removeEmployeeById(@PathVariable("id") Long id){
		try {
			//use service
			String deleteEmployee = employeeService.deleteEmployeeById(id);
			return new ResponseEntity<String>(deleteEmployee,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
