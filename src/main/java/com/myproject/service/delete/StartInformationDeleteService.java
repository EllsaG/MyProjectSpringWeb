package com.myproject.service.delete;

import com.myproject.entity.StartInformation;
import com.myproject.service.startinformation.StartInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class StartInformationDeleteService {

    StartInformationService startInformationService;

    @Autowired
    public StartInformationDeleteService(StartInformationService startInformationService) {
        this.startInformationService = startInformationService;
    }

    public String delete(Long startInformId){
        StartInformation startInformation= startInformationService.getInformationById(startInformId);
        String name = startInformation.getName();
        BigDecimal power = startInformation.getPower();
        BigInteger amount = startInformation.getAmount();
        startInformationService.delete(startInformation);
        return "Information about  equipment № " + startInformId +
                "\n  name " + name +
                "\n  power " + power +
                "\n  amount " + amount +
                "\nis deleted";
    }


}
