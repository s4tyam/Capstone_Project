package com.sutherland.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sutherland.lms.entity.Employee;
import com.sutherland.lms.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo repo;
	@Override
	public Employee getEmployeeById(String empId) {
		Optional<Employee> emp = repo.findById(empId);
		return emp.get();
	}

	@Override
	public void addEmployee(Employee emp) {
		repo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> empl = repo.findAll();
		return empl;
	}
	
}
