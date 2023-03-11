package com.myproject.service.startinformation.update;

import com.myproject.controller.dto.startinformation.refresh.StartInformationRefreshResponseDTO;
import com.myproject.entity.StartInformation;
import com.myproject.service.startinformation.postget.StartInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartInformationUpdateService {

    private final StartInformationService startInformationService;

    @Autowired
    public StartInformationUpdateService(StartInformationService startInformationService) {
        this.startInformationService = startInformationService;
    }

    public StartInformationRefreshResponseDTO update(Long startInformId, String name, double power, int amount,
                         double ki, double cosf, double tgf) {
        StartInformation startInformation = startInformationService.getInformationById(startInformId);
        startInformation.setName(name);
        startInformation.setPower(power);
        startInformation.setAmount(amount);
        startInformation.setKi(ki);
        startInformation.setCosf(cosf);
        startInformation.setTgf(tgf);
        startInformationService.update(startInformation);
        return new StartInformationRefreshResponseDTO(startInformationService.getAllStartInformation());
    }



}
