package com.vdab.rdcar.controllers;

import com.vdab.rdcar.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employee")
    public String showEmployeePage(Model model) {
        model.addAttribute("allEmployees", employeeService.getEmployees());
        return "employee";
    }
}
