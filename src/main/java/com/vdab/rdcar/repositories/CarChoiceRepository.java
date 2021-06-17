package com.vdab.rdcar.repositories;

import com.vdab.rdcar.domain.CarChoice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarChoiceRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<CarChoice> getOrderCars() {
        TypedQuery<CarChoice> carChoiceTypedQuery = entityManager.createQuery("select cc from CarChoice cc", CarChoice.class);
        return carChoiceTypedQuery.getResultList();
    }

    public CarChoice findCarById(long id) {
        return entityManager.find(CarChoice.class, id);
    }
}
