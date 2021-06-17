package com.vdab.rdcar.repositories;

import com.vdab.rdcar.domain.Employee;
import com.vdab.rdcar.domain.LeasedCar;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class LeasedCarRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional(rollbackOn = Exception.class)
    public void save(LeasedCar newCar) {
        entityManager.merge(newCar);
    }

    public List<LeasedCar> getLeasedCars() {
        TypedQuery<LeasedCar> cars = entityManager.createQuery("select lc from LeasedCar lc", LeasedCar.class);
        return cars.getResultList();
    }

    public LeasedCar findLeasedCarById(long id) {

        return entityManager.find(LeasedCar.class,id);
    }
    @Transactional
    public void updateLeasedCar(LeasedCar leasedCar) {

        entityManager.merge(leasedCar);
    }
    @Transactional
    public void removeLeasedCar(long id) {
        LeasedCar leasedCar = findLeasedCarById(id);
        entityManager.remove(leasedCar);
    }
}