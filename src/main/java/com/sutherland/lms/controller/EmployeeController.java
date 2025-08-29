package com.sutherland.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sutherland.lms.entity.Employee;
import com.sutherland.lms.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/addemployee")
	public void addEmployee(@RequestBody Employee employee) {
		service.addEmployee(employee);
	}
	
	@GetMapping("/getemployeebyid/{id}")
	public Employee getEmployeeByID(@PathVariable String id) {
		return service.getEmployeeById(id);
	}
	
	@GetMapping("/allemployee")
	public List<Employee> getAllEmployee(){
		return service.getAllEmployee();
	}
}
