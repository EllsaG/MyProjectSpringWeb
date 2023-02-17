package com.myproject.service.startinformation.update;

import com.myproject.entity.StartInformation;
import com.myproject.service.startinformation.postget.StartInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class StartInformationUpdateService {

    private final StartInformationService startInformationService;

    @Autowired
    public StartInformationUpdateService(StartInformationService startInformationService) {
        this.startInformationService = startInformationService;
    }

    public String update(Long startInformId, String name, double power, int amount,
                         double ki, double cosf, double tgf) {
        StartInformation startInformation = startInformationService.getInformationById(startInformId);
        String oldName = startInformation.getName();
        double oldPower = startInformation.getPower();
        int oldAmount = startInformation.getAmount();
        double oldKi = startInformation.getKi();
        double oldCosf = startInformation.getCosf();
        double oldTgf = startInformation.getTgf();
        startInformation.setName(name);
        startInformation.setPower(power);
        startInformation.setAmount(amount);
        startInformationService.update(startInformation);
        return "Information about equipment № " + startInformId + " has been updated" +
                "\nOld information about equipment № "+ startInformId +
                        "\n  name " + oldName +
                        "\n  power " + oldPower +
                        "\n  amount " + oldAmount +
                        "\n  name " + oldKi +
                        "\n  power " + oldCosf +
                        "\n  amount " + oldTgf +
                "\nNew information about equipment № "+ startInformId +
                        "\n  name " + name +
                        "\n  power " + power +
                        "\n  amount " + amount +
                        "\n  name " + ki +
                        "\n  power " + cosf +
                        "\n  amount " + tgf ;
    }



}