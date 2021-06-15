package com.vdab.rdcar.controllers;

import com.vdab.rdcar.services.CarService;
import com.vdab.rdcar.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActionsController {

    @Autowired
    private CarService carService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/")
    public String showHomePage(){
        return "index";
    }


}
