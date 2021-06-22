package com.vdab.rdcar.controllers;

import com.vdab.rdcar.domain.CarChoice;
import com.vdab.rdcar.domain.Colour;
import com.vdab.rdcar.domain.Employee;
import com.vdab.rdcar.domain.LeasedCar;
import com.vdab.rdcar.services.LeasedCarService;
import com.vdab.rdcar.services.EmployeeService;
import com.vdab.rdcar.services.CarChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderCarController {
    @Autowired
    private CarChoiceService carChoiceService;
    @Autowired
    private LeasedCarService leasedCarService;
    @Autowired
    private EmployeeService employeeService;


    @RequestMapping(value = "/car", method = {RequestMethod.GET, RequestMethod.POST})
    public String showOrderCarPage(@ModelAttribute Employee employee, CarChoice carChoice, Model model) {
        List<CarChoice> orderCars = carChoiceService.getOrderCars();
        if (employee.getId() != null) {
            employee = employeeService.findById(employee.getId());
            switch (employee.getCarCategory()) {
                case "2":
                    orderCars = orderCars.stream().filter(carChoice1 -> carChoice1.getCat().equals("2") || carChoice1.getCat().equals("3")).collect(Collectors.toList());
                    break;
                case "3":
                    orderCars = orderCars.stream().filter(carChoice1 -> carChoice1.getCat().equals("2") || carChoice1.getCat().equals("3") || carChoice1.getCat().equals("4")).collect(Collectors.toList());
                    break;
                case "4":
                    orderCars = orderCars.stream().filter(carChoice1 -> carChoice1.getCat().equals("3") || carChoice1.getCat().equals("4") || carChoice1.getCat().equals("5")).collect(Collectors.toList());
                    break;
                case "5":
                    orderCars = orderCars.stream().filter(carChoice1 -> carChoice1.getCat().equals("4") || carChoice1.getCat().equals("5") || carChoice1.getCat().equals("6")).collect(Collectors.toList());
                    break;
                case "6":
                    orderCars = orderCars.stream().filter(carChoice1 -> carChoice1.getCat().equals("5") || carChoice1.getCat().equals("6") || carChoice1.getCat().equals("6+")).collect(Collectors.toList());
                    break;
                case "6+":
                    orderCars = orderCars.stream().filter(carChoice1 -> carChoice1.getCat().equals("6") || carChoice1.getCat().equals("6+")).collect(Collectors.toList());
                    break;
            }
        }


        model.addAttribute("allAvailableCars", orderCars);
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("employee", employee);
        return "carchoices";
    }

    @GetMapping(value = "/ordercar/{id}/{employeeId}")
    public String showCarPage(@PathVariable("employeeId") long employeeId,@PathVariable("id") long id, Model model) {
        model.addAttribute("carChoice", carChoiceService.findCarById(id));
        model.addAttribute("leasedCar", new LeasedCar());
        model.addAttribute("employee", employeeService.findById(employeeId));
        model.addAttribute("colours", Colour.values());
        return "orderingcar";
    }

    @PostMapping(value = "/orderingCar/{id}")
    public String Ordering(@ModelAttribute LeasedCar newCar) {
        leasedCarService.save(newCar);
        return "redirect:/carpark";
    }

}
