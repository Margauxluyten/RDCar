package com.vdab.rdcar.controllers;

import com.vdab.rdcar.domain.LeasedCar;
import com.vdab.rdcar.services.LeasedCarService;
import com.vdab.rdcar.services.EmployeeService;
import com.vdab.rdcar.services.CarChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderCarController {
    @Autowired
    private CarChoiceService carChoiceService;
    @Autowired
    private LeasedCarService leasedCarService;
    @Autowired
    private EmployeeService employeeService;


    @GetMapping(value = "/car")
    public String ShowOrderCarPage(Model model) {
        model.addAttribute("allAvailableCars", carChoiceService.getOrderCars());
        return "carchoices";
    }

    @GetMapping(value = "/ordercar/{id}")
    public String showCarPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("carChoice", carChoiceService.findCarById(id));
        model.addAttribute("leasedCar", new LeasedCar());
        model.addAttribute("employees", employeeService.getEmployees());
        return "orderingcar";
    }

    @PostMapping(value = "/orderingCar/{id}")
    public String Ordering(@ModelAttribute LeasedCar car) {
        leasedCarService.save(car);
        return "redirect:/carpark";
    }

}
