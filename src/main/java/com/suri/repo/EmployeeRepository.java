package com.suri.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suri.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
