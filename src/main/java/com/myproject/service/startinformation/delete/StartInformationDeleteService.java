package com.myproject.service.startinformation.delete;

import com.myproject.entity.StartInformation;
import com.myproject.service.startinformation.postget.StartInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
        double power = startInformation.getPower();
        int amount = startInformation.getAmount();
        double Ki = startInformation.getKi();
        double Cosf = startInformation.getCosf();
        double Tgf = startInformation.getTgf();
        startInformationService.delete(startInformation);
        return "Information about  equipment № " + startInformId +
                "\n  name " + name +
                "\n  power " + power +
                "\n  amount " + amount +
                "\n  ki " + Ki +
                "\n  cosf " + Cosf +
                "\n  tgf " + Tgf +
                "\nhas been deleted";
    }


}
