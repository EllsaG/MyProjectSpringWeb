package com.myproject.service.startinformation.postget;

import com.myproject.entity.StartInformation;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.matching.StartInformationMatching;
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

    public String save(Long startInformId, String name, BigDecimal power, BigInteger amount,
                       BigDecimal ki, BigDecimal cosf, BigDecimal tgf) {
        StartInformation startInformation = StartInformationMatching
                .createIfDontExist(startInformationRepository, startInformId, name, power, amount, ki, cosf, tgf);// method checked only by id(because i don't know why it doesn't work)
        return "Information about new equipment № " +
                startInformationRepository.save(startInformation).getStartInformId() +
                "\n  name " + name +
                "\n  power " + power +
                "\n  amount " + amount +
                "\n  name " + ki +
                "\n  power " + cosf +
                "\n  amount " + tgf +
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
