package com.java.emt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.java.emt.exception.ResourceNotFoundException;
import com.java.emt.model.Address;
import com.java.emt.model.Employee;
import com.java.emt.model.ExAssociate;
import com.java.emt.repository.EmployeeRepository;
import com.java.emt.repository.ExAssociateRepository;
import com.java.emt.service.EmployeeService;
import com.java.emt.service.ExAssociateSetter;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ExAssociateRepository exAssociateRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		 return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long empId) {
	    return employeeRepository.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id",empId));
	}

	@Override
	public Employee updateEmployee(Long empId, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "empId", empId));

	    employee.setFirstName(employeeDetails.getFirstName());
	    employee.setLastName(employeeDetails.getLastName());
	    employee.setGender(employeeDetails.getGender());
	    employee.setAge(employeeDetails.getAge());
	    employee.setAddress(employeeDetails.getAddress());
	    employee.setDateOfBirth(employeeDetails.getDateOfBirth());
	    employee.setContactNo(employeeDetails.getContactNo());
	    employee.setDesignation(employeeDetails.getDesignation());
	    Employee updatedEmployee = employeeRepository.save(employee);
	    return updatedEmployee;
	}

	@Override
	public Employee updateAddress(Long empId, Employee employeeDetails) {

		Employee employee = employeeRepository.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "empId", empId));
		Address address = employeeDetails.getAddress();
	    employee.setAddress(address);
	    Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee;
	}

	@Override
	public Employee updateDesignation(Long empId, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "empId", empId));
	    employee.setDesignation(employeeDetails.getDesignation());
	    Employee updatedEmployee = employeeRepository.save(employee);
	    return updatedEmployee;
	}

	@Override
	public ResponseEntity<?> deleteEmployee(Long empId) {
	    Employee employee = employeeRepository.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));
	    ExAssociate exAssociate = new ExAssociate() ;
	    ExAssociateSetter exAssociateSetter = new ExAssociateSetter();
	    exAssociate= exAssociateSetter.setExAssociate(employee);
	    employeeRepository.delete(employee);
	    exAssociateRepository.save(exAssociate);
	    return ResponseEntity.ok().build();
	}

}
