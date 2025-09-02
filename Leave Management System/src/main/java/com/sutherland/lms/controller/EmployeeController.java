package com.sutherland.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sutherland.lms.entity.Employee;
import com.sutherland.lms.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins =  "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>("Employee added successfully", HttpStatus.OK);
    }

    @GetMapping("/getdetails/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String empId) {
        return employeeService.getEmployeeById(empId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/manager/{managerId}")
    public ResponseEntity<List<Employee>> getEmployeesByManager(@PathVariable String managerId) {
        List<Employee> employees = employeeService.getEmployeeByManager(managerId);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
    @PostMapping("/login")
    public ResponseEntity<Employee> login(@RequestBody Employee loginRequest) {
        String empId = loginRequest.getEmpId();
        String password = loginRequest.getPassword();

        return employeeService.verifyLogin(empId, password);
    }

}
