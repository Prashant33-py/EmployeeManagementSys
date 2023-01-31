package com.employeeDetails.EmployeeManagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable=false)
    private String username;

    @Column(name = "passwd",nullable=false)
    private String passwd;

    @Column(name = "role", nullable = false)
    private String role;
}
