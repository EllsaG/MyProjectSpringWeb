package com.myproject.service.startinformation;

import com.myproject.entity.StartInformation;
import com.myproject.exceptions.InformationAlreadyExistsException;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.matching.StartInformationMatching;
import com.myproject.repositories.StartInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

@Service
public class StartInformationService {

    private final StartInformationRepository startInformationRepository;

    @Autowired
    public StartInformationService(StartInformationRepository startInformationRepository) {
        this.startInformationRepository = startInformationRepository;
    }

    public String save(Long startInformId, String name, BigDecimal power, BigInteger amount) {
        StartInformation startInformation = StartInformationMatching
                .createIfDontExist(startInformationRepository,startInformId,name, power, amount);
        return "Information about new equipment № " +
                startInformationRepository.save(startInformation).getStartInformId() +
                "\n  name " + name +
                "\n  power " + power +
                "\n  amount " + amount +
                "\nis saved";
    }

    public StartInformation getInformationById(Long startInformId) {
        return startInformationRepository.findById(startInformId)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about equipment with id № " + startInformId));
    }

    public StartInformation update(StartInformation startInformation) {
        return startInformationRepository.save(startInformation);
    }

    public void delete(StartInformation startInformation) {
        startInformationRepository.delete(startInformation);
    }


}
