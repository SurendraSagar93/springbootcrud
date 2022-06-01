package com.suri.service;

import java.util.List;

import com.suri.entity.Employee;
import com.suri.exception.EmplyeeNotFoundException;

public interface EmployeeService {
	
	public String createEmployee(Employee employee);
	public List<Employee> fetchAllEmployee();
	public Employee fetechEmployeeById(Long id) throws EmplyeeNotFoundException;
	public String updateEmployeeDetails(Employee employee)throws EmplyeeNotFoundException;
	public String deleteEmployeeById(Long id)throws EmplyeeNotFoundException;

}
