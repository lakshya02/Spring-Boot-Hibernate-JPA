package com.java.emt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.emt.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
