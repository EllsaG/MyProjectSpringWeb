package com.myproject.service.update;

import com.myproject.controller.dto.StartInformationRequestDTO;
import com.myproject.entity.StartInformation;
import com.myproject.service.startinformation.StartInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class StartInformationUpdateService {

    private final StartInformationService startInformationService;

    @Autowired
    public StartInformationUpdateService(StartInformationService startInformationService) {
        this.startInformationService = startInformationService;
    }

    public String update(Long startInformId,String name, BigDecimal power, BigInteger amount) {
        StartInformation startInformation = startInformationService.getInformationById(startInformId);
        String oldName = startInformation.getName();
        BigDecimal oldPower = startInformation.getPower();
        BigInteger oldAmount = startInformation.getAmount();
        startInformation.setName(name);
        startInformation.setPower(power);
        startInformation.setAmount(amount);
        startInformationService.update(startInformation);
        return "Information about equipment № " + startInformId + " has been updated" +
                "\nOld information about equipment № "+ startInformId +
                        "\n  name " + oldName +
                        "\n  power " + oldPower +
                        "\n  amount " + oldAmount +
                "\nNew information about equipment № "+ startInformId +
                        "\n  name " + name +
                        "\n  power " + power +
                        "\n  amount " + amount ;
    }



}
