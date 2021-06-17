package com.vdab.rdcar.repositories;

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

    public List<LeasedCar> getAllCars() {
            TypedQuery<LeasedCar> cars = entityManager.createQuery("select lc from LeasedCar lc", LeasedCar.class);
            return cars.getResultList();
    }

    @Transactional(rollbackOn = Exception.class)
    public void save(LeasedCar newCar) {

        entityManager.merge(newCar);
    }
}
