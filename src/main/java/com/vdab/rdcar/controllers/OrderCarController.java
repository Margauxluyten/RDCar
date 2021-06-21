package com.vdab.rdcar.controllers;

import com.vdab.rdcar.domain.CarChoice;
import com.vdab.rdcar.domain.Employee;
import com.vdab.rdcar.domain.LeasedCar;
import com.vdab.rdcar.services.ColourService;
import com.vdab.rdcar.services.LeasedCarService;
import com.vdab.rdcar.services.EmployeeService;
import com.vdab.rdcar.services.CarChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderCarController {
    @Autowired
    private CarChoiceService carChoiceService;
    @Autowired
    private LeasedCarService leasedCarService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ColourService colourService;


    @RequestMapping(value = "/car", method = {RequestMethod.GET, RequestMethod.POST})
    public String showOrderCarPage(@ModelAttribute Employee employee, CarChoice carChoice, Model model) {
        if(employee.getId() != null){
            Employee employee1 = employeeService.findById(employee.getId());
        }
//        if(employee.getCarCategory() == carChoice.getCat() &&
//        carChoice.getCat() -1  == employee.getCarCategory() &&
//        carChoice.getCat() +1 == employee.getCarCategory()){
//            model.addAttribute("availableCategoryCars", carChoiceService.getOrderCars());
//        }
        model.addAttribute("allAvailableCars", carChoiceService.getOrderCars());
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("employee", new Employee());
        return "carchoices";
    }

    @GetMapping(value = "/ordercar/{id}")
    public String showCarPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("carChoice", carChoiceService.findCarById(id));
        model.addAttribute("leasedCar", new LeasedCar());
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("colours", colourService.getColours());
        return "orderingcar";
    }

    @PostMapping(value = "/orderingCar/{id}")
    public String Ordering(@ModelAttribute LeasedCar newCar) {
        leasedCarService.save(newCar);
        return "redirect:/carpark";
    }

}
