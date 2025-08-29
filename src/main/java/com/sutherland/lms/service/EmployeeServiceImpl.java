package com.sutherland.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sutherland.lms.entity.Employee;
import com.sutherland.lms.exceptions.EmployeeIdWrongException;
import com.sutherland.lms.exceptions.EmployeeNotFoundException;
import com.sutherland.lms.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo repo;
	
	@Override
	public Employee getEmployeeById(String empId) {
		Optional<Employee> emp = repo.findById(empId);
		if(emp.isEmpty()) throw new EmployeeNotFoundException("Employee with this id not Exit...");
		return emp.get();
	}

	@Override
	public void addEmployee(Employee emp) {
		  if(emp.getEmpId().length() <= 9 && emp.getEmpId().startsWith("SUTH25")) {
			  if ("MANAGER".equalsIgnoreCase(emp.getJob())) {
		            emp.setManagerId(null);
		        } else {
		        	 Optional<Employee> managerId = repo.findById(emp.getManagerId());
		        	 if(managerId.isEmpty()) throw new EmployeeNotFoundException("Manager not Found...");
		        }
			  repo.save(emp);
		  }else throw new EmployeeIdWrongException("Employee id Wrong");
	    }

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> empl = repo.findAll();
		return empl;
	}
	
}
