package com.employeeDetails.EmployeeManagement.controller;

import com.employeeDetails.EmployeeManagement.model.Employee;
import com.employeeDetails.EmployeeManagement.repository.UserRepository;
import com.employeeDetails.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;
    private final UserRepository userRepository;


    public EmployeeController(EmployeeService employeeService,
                              UserRepository userRepository) {
        this.employeeService = employeeService;
        this.userRepository = userRepository;
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        System.out.println(model.getAttribute("listEmployees"));
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
