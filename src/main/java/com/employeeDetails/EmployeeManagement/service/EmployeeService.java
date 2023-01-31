package com.employeeDetails.EmployeeManagement.service;

import com.employeeDetails.EmployeeManagement.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    void updateEmployee(long id, Employee employee);

    void deleteEmployeeById(long id);

    void addEmployee(Employee employee);
}
