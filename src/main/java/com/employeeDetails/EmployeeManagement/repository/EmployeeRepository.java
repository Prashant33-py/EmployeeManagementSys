package com.employeeDetails.EmployeeManagement.repository;

import com.employeeDetails.EmployeeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
