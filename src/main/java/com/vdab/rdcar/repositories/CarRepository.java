package com.vdab.rdcar.repositories;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CarRepository {

    @PersistenceContext
    private EntityManager entityManager;
}
