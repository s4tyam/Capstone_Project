package com.sutherland.lms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sutherland.lms.entity.Employee;

public interface EmployeeService {
	ResponseEntity<Employee> getEmployeeById(String empId);
	void addEmployee(Employee emp);
	List<Employee> getAllEmployee();
	List<Employee> getEmployeeByManager(String empId);
	
	ResponseEntity<Employee> verifyLogin(String empId, String password);
}
