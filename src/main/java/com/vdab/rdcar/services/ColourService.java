package com.vdab.rdcar.services;

import com.vdab.rdcar.domain.Colour;
import com.vdab.rdcar.repositories.ColourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColourService {
    @Autowired
    private ColourRepository colourRepository;

    public List<Colour> getColours(){
        return colourRepository.getAllColours();
    }
}
