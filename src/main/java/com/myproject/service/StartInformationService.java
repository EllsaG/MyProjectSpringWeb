package com.myproject.service;

import com.myproject.entity.StartInformation;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class StartInformationService {

    private final InformationRepository informationRepository;

    @Autowired
    public StartInformationService(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    public String save(String name, BigDecimal power, BigInteger amount) {
        StartInformation startInformation = new StartInformation(name, power, amount);
        return ("Information about equipment № " +
                informationRepository.save(startInformation).getStartInformId()) +
                " is saved";
    }

    public StartInformation getInformationById(Long startInformId){
        return informationRepository.findById(startInformId)
                .orElseThrow(()->
                        new InformationNotFoundException("Unable to find information about equipment with id: " + startInformId));
    }

}
