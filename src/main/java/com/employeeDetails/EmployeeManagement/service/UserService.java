package com.employeeDetails.EmployeeManagement.service;

import com.employeeDetails.EmployeeManagement.model.User;

public interface UserService {
    User findByUsername(String username);
}
