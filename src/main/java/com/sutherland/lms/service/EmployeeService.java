package com.sutherland.lms.service;

import java.util.List;

import com.sutherland.lms.entity.Employee;

public interface EmployeeService {
	Employee getEmployeeById(String empId);
	void addEmployee(Employee emp);
	List<Employee> getAllEmployee();
}
