package com.vdab.rdcar.repositories;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;
}
