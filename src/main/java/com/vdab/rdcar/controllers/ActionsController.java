package com.vdab.rdcar.controllers;

import com.vdab.rdcar.domain.Employee;
import com.vdab.rdcar.services.LeasedCarService;
import com.vdab.rdcar.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ActionsController {

    @Autowired
    private LeasedCarService leasedCarService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/")
    public String showHomePage(){
        return "index";
    }

    @GetMapping(value = "/addEmployee")
    public String showAddEmployee(Model model){
        model.addAttribute("newEmployee", new Employee());
        return "addemployee";
    }
    @PostMapping(value = "/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee newEmployee){
        employeeService.saveEmployee(newEmployee);
        return "redirect:/employee";
    }
    @GetMapping(value = "/editEmployee/{id}")
    public String showEditEmployee(@PathVariable("id")long id, Model model) {
        model.addAttribute("editemployee",employeeService.findById(id));
        return "editemployee";
    }
    @PostMapping(value = "/editedEmployee/{id}")
    public String editedEmployeePage(@ModelAttribute Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/employee";
    }
    @GetMapping(value = "/removeEmployee/{id}")
    public String deleteEmployee(@PathVariable("id")long id){
        employeeService.removeEmployee(id);
        return "redirect:/employee";
    }
}
