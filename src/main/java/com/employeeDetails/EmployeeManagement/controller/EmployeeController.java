package com.employeeDetails.EmployeeManagement.controller;

import com.employeeDetails.EmployeeManagement.model.Employee;
import com.employeeDetails.EmployeeManagement.service.EmployeeService;
import com.employeeDetails.EmployeeManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

//    @GetMapping("/")
//    public String login(){
//        return "login";
//    }

    @GetMapping("/")
    public String index(Model model){
        System.out.println(userService.findByUsername("admin"));
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "add_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @PostMapping("/editEmployee/{id}")
    public String ediEmployee(@PathVariable(value = "id") long id, @ModelAttribute("employee") Employee employee){
        employeeService.updateEmployee(id,employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") long id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "edit_employee";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") long id, Model model){
        employeeService.deleteEmployeeById(id);
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "redirect:/";
    }
}
