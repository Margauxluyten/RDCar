package com.vdab.rdcar.controllers;

import com.vdab.rdcar.services.LeasedCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarParkController {

    @Autowired
    private LeasedCarService leasedCarService;

    @GetMapping(value = "/carpark")
    public String showCarParkPage(){

        return "carpark";
    }



}
