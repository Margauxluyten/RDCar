package com.vdab.rdcar.services;

import com.vdab.rdcar.domain.Employee;
import com.vdab.rdcar.domain.LeasedCar;
import com.vdab.rdcar.repositories.LeasedCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeasedCarService {
    @Autowired
    private LeasedCarRepository leasedCarRepository;


    public void save(LeasedCar car) {

        leasedCarRepository.save(car);
    }

    public List<LeasedCar> getLeasedCars() {
        return leasedCarRepository.getLeasedCars();
    }

    public LeasedCar findLeasedCarById(long id) {
        return leasedCarRepository.findLeasedCarById(id);
    }

    public void updateLeasedCar(LeasedCar leasedCar) {
        leasedCarRepository.updateLeasedCar(leasedCar);
    }

    public void removeLeasedCar(long id) {
        leasedCarRepository.removeLeasedCar(id);
    }
}
