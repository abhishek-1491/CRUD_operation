package com.example.CRUD.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CRUD.entity.Employee;
import com.example.CRUD.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAllEmployee() {
		List<Employee> allEmployees = employeeRepository.findAll();
		return allEmployees;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	@Override
	public Employee updateEmployeeById(Long id, Employee employee) {
		Optional<Employee> employee1 = employeeRepository.findById(id);
		
		if(employee1.isPresent()) {
			Employee originalEmployee = employee1.get();
			
			if(Objects.nonNull(employee.getEmpName()) && !"".equalsIgnoreCase(employee.getEmpName())) {
				originalEmployee.setEmpName(employee.getEmpName());
			}
			if(Objects.nonNull(employee.getEmpSalary()) && employee.getEmpSalary() !=0) {
				originalEmployee.setEmpSalary(employee.getEmpSalary());
			}
			if(Objects.nonNull(employee.getEmpAddress()) && !"".equalsIgnoreCase(employee.getEmpAddress())) {
				originalEmployee.setEmpName(employee.getEmpAddress());
			}
			return employeeRepository.save(originalEmployee);
		}
		return null;
	}

	@Override
	public String deleteDepartmentById(Long id) {
		if(employeeRepository.findById(id).isPresent()) {
			employeeRepository.deleteById(id);
			return "Employee deleted successfully";
		}
		return "No such employee in the database";
	}

}
