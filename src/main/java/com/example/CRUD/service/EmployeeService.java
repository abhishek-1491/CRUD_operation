package com.example.CRUD.service;

import java.util.List;

import com.example.CRUD.entity.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	List<Employee> fetchAllEmployee();
	Employee getEmployeeById(Long id);
	Employee updateEmployeeById(Long id, Employee employee);
	String deleteDepartmentById(Long id);

}
