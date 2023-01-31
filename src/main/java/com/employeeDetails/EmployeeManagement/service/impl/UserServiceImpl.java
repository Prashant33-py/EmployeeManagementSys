package com.employeeDetails.EmployeeManagement.service.impl;

import com.employeeDetails.EmployeeManagement.model.User;
import com.employeeDetails.EmployeeManagement.repository.UserRepository;
import com.employeeDetails.EmployeeManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
