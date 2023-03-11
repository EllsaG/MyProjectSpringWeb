package com.myproject.service.startinformation.delete;

import com.myproject.controller.dto.startinformation.refresh.StartInformationRefreshResponseDTO;
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

    public StartInformationRefreshResponseDTO delete(Long startInformId){
        StartInformation startInformation= startInformationService.getInformationById(startInformId);
        startInformationService.delete(startInformation);
        return new StartInformationRefreshResponseDTO(startInformationService.getAllStartInformation());
    }


}
