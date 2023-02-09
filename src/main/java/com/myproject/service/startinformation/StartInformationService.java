package com.myproject.service.startinformation;

import com.myproject.controller.dto.StartInformationRequestDTO;
import com.myproject.entity.StartInformation;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.StartInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class StartInformationService {

    private final StartInformationRepository startInformationRepository;

    @Autowired
    public StartInformationService(StartInformationRepository startInformationRepository) {
        this.startInformationRepository = startInformationRepository;
    }

    public String save(String name, BigDecimal power, BigInteger amount) {
        StartInformation startInformation = new StartInformation(name, power, amount);
        return ("Information about the equipment № " +
                startInformationRepository.save(startInformation).getStartInformId()) +
                " is saved";
    }

    public StartInformation getInformationById(Long startInformId) {
        return startInformationRepository.findById(startInformId)
                .orElseThrow(() ->
                        new InformationNotFoundException("Unable to find information about equipment with id: " + startInformId));
    }



}
