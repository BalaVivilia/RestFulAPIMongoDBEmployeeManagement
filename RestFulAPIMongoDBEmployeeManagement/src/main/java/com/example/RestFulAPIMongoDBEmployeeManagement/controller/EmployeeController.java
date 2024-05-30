package com.example.RestFulAPIMongoDBEmployeeManagement.controller;

import com.example.RestFulAPIMongoDBEmployeeManagement.model.Employee;
import com.example.RestFulAPIMongoDBEmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/addEmployee")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/displayAll")
    public String displayAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "displayAll";
    }

    @GetMapping("/display")
    public String displayEmployeeById(@RequestParam("id") String id, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
        } else {
            model.addAttribute("error", "Employee not found");
        }
        return "display";
    }
}

