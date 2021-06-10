package com.vdab.rdcar.controllers;

import com.vdab.rdcar.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CarController {

    @Autowired
    private CarService carService;


}
