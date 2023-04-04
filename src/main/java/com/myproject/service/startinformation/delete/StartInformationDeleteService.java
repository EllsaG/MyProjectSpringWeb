package com.myproject.service.startinformation.delete;

import com.myproject.controller.dto.startinformation.postget.StartInformationResponseDTO;
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

    public StartInformationResponseDTO delete(long startInformId){
        StartInformation startInformation= startInformationService.getInformationById(startInformId);
        startInformationService.delete(startInformation);
        return new StartInformationResponseDTO(startInformationService.getAllStartInformation());
    }


}
