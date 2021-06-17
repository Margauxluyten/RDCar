package com.vdab.rdcar.services;

import com.vdab.rdcar.domain.CarChoice;
import com.vdab.rdcar.repositories.CarChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarChoiceService {
    @Autowired
    private CarChoiceRepository carChoiceRepository;

    public List<CarChoice> getOrderCars() {

        return carChoiceRepository.getOrderCars();
    }


    public CarChoice findCarById(long id) {
        return carChoiceRepository.findCarById(id);
    }
}
