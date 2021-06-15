package com.vdab.rdcar.repositories;

import com.vdab.rdcar.domain.Car;
import com.vdab.rdcar.domain.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Car> getCar() {
            TypedQuery<Car> cars = entityManager.createQuery("select c from Car c",Car.class);
            return cars.getResultList();
    }
}
