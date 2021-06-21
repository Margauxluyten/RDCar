package com.vdab.rdcar.repositories;

import com.vdab.rdcar.domain.Colour;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class ColourRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Colour> getAllColours() {
        return entityManager.createQuery("select c from Colour c",Colour.class).getResultList();
    }
}
