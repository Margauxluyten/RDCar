package com.vdab.rdcar.services;

import com.vdab.rdcar.domain.LeasedCar;
import com.vdab.rdcar.repositories.LeasedCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeasedCarService {
    @Autowired
    private LeasedCarRepository leasedCarRepository;


    public void save(LeasedCar car) {
        leasedCarRepository.save(car);
    }
}
