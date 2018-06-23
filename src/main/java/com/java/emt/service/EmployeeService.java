package com.java.emt.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.java.emt.model.Employee;


public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee addEmployee(Employee employee);
	public Employee getEmployeeById(Long empId);
	public Employee updateEmployee(Long empId, Employee employeeDetails); 
	public Employee updateAddress(Long empId,Employee employeeDetails);
	public Employee updateDesignation(Long empId,Employee employeeDetails);
	public ResponseEntity<?> deleteEmployee(Long empId);
}
