package com.java.emt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.emt.model.Employee;
import com.java.emt.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("/emp")
	public List<Employee> getAllEmployees() {
	    return employeeService.getAllEmployees();
	}

	
	@PostMapping("/emp")
	public Employee addEmployee(@RequestBody Employee employee) {
		    return employeeService.addEmployee(employee);
	}
	
	
	@GetMapping("/emp/{empId}")
	public Employee getEmployeeById(@PathVariable(value = "empId") Long empId) {
	    return employeeService.getEmployeeById(empId);
	}
	
	
	@PutMapping("/emp/{empId}")
	public Employee updateEmployee(@PathVariable(value = "empId") Long empId,
	                                         @RequestBody Employee employeeDetails) {

		return employeeService.updateEmployee(empId, employeeDetails);
	}
	
	
	@PutMapping("/updateAddress/{empId}")
	public Employee updateAddress(@PathVariable(value = "empId") Long empId,
	                                         @RequestBody Employee employeeDetails) {

		return employeeService.updateAddress(empId, employeeDetails);
	         
	}
	
	@PutMapping("/promoteEmp/{empId}")
	public Employee updateDesignation(@PathVariable(value = "empId") Long empId,
	                                         @RequestBody Employee employeeDetails) {

		return employeeService.updateDesignation(empId, employeeDetails);

	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long empId) {
	    return employeeService.deleteEmployee(empId);
	}
}
