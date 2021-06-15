package com.vdab.rdcar.controllers;

import com.vdab.rdcar.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/car")
    public String showCarPage(Model model) {
        model.addAttribute("allCar", carService.getCar());
        return "car";
    }


}
