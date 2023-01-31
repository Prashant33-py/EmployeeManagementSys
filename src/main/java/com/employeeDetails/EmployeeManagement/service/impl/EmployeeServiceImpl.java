package com.employeeDetails.EmployeeManagement.service.impl;

import com.employeeDetails.EmployeeManagement.model.Employee;
import com.employeeDetails.EmployeeManagement.repository.EmployeeRepository;
import com.employeeDetails.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void addEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(long id, Employee employee) {
        employee.setId(id);
        this.employeeRepository.save(employee);
    }


    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }
}
