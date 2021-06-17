package com.vdab.rdcar.controllers;

import com.vdab.rdcar.domain.LeasedCar;
import com.vdab.rdcar.services.LeasedCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarParkController {

    @Autowired
    private LeasedCarService leasedCarService;

    @GetMapping(value = "/carpark")
    public String showCarParkPage(Model model){
        model.addAttribute("allLeasedCars",leasedCarService.getLeasedCars());
        return "carpark";
    }

    @GetMapping(value = "/editLeasedCar/{id}")
    public String showEditLeasedCarPage(@PathVariable("id")long id,Model model){
        LeasedCar leasedCarById = leasedCarService.findLeasedCarById(id);
        model.addAttribute("editLeasedCar", leasedCarById);
        if(leasedCarById.getRegistrationDate() == null){
            model.addAttribute("showRegistrationDate", true);
        }else{
            model.addAttribute("showRegistrationDate", false);
        }
        return "editleasedcar";
    }

    @PostMapping(value = "/editedLeasedCar/{id}")
    public String editedLeasedCarPage(@ModelAttribute LeasedCar leasedCar ){
        LeasedCar leasedCarFromDb = leasedCarService.findLeasedCarById(leasedCar.getId());

        leasedCarFromDb.setMileage(leasedCar.getMileage());
        leasedCarFromDb.setRegistrationDate(leasedCar.getRegistrationDate());
        leasedCarService.updateLeasedCar(leasedCarFromDb);
        return "redirect:/carpark";
    }

    @GetMapping(value = "/removeLeasedCar/{id}")
    public String deleteLeasedCar(@PathVariable("id")long id){
        leasedCarService.removeLeasedCar(id);
        return "redirect:/carpark";
    }
}
