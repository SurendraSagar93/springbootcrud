package com.suri.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suri.entity.Employee;
import com.suri.exception.EmplyeeNotFoundException;
import com.suri.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String createEmployee(Employee employee) {
		Long idVal = employeeRepository.save(employee).getId();
		return "Employee Saved with id :: " + idVal;
	}

	@Override
	public List<Employee> fetchAllEmployee() {
		List<Employee> list = employeeRepository.findAll();
		return list;
	}

	@Override
	public Employee fetechEmployeeById(Long id) throws EmplyeeNotFoundException {

		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmplyeeNotFoundException(id + "Employee Not found"));
	}

	@Override
	public String updateEmployeeDetails(Employee employee) throws EmplyeeNotFoundException {
		Optional<Employee> optional = employeeRepository.findById(employee.getId());
		if (optional.isPresent()) {
			employeeRepository.save(employee);
			return employee.getId()+ "Employee is Updated";
			
		}
		else {
			throw new EmplyeeNotFoundException(employee.getId()+ "Not Found");
		}
	}

	@Override
	public String deleteEmployeeById(Long id) throws EmplyeeNotFoundException {
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isPresent()) {
			employeeRepository.delete(optional.get());
			return id+ "employee deleted succesfully";
			
		}
		else {
			throw new EmplyeeNotFoundException(id+ "employee not found");
		}
	}

}
