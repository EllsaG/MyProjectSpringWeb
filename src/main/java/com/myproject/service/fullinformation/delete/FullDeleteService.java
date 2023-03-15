package com.myproject.service.fullinformation.delete;

import com.myproject.controller.dto.fullinformation.refresh.FullInformationRefreshResponseDTO;
import com.myproject.controller.dto.startinformation.refresh.StartInformationRefreshResponseDTO;
import com.myproject.entity.FullInformation;
import com.myproject.service.fullinformation.postget.FullInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FullDeleteService {

    FullInformationService fullInformationService;
@Autowired
    public FullDeleteService(FullInformationService fullInformationService) {
        this.fullInformationService = fullInformationService;
    }

    public FullInformationRefreshResponseDTO deleteInfoById(Long id){
        FullInformation informationById = fullInformationService.getInformationById(id);
        fullInformationService.delete(informationById);
        return new FullInformationRefreshResponseDTO(fullInformationService.getAllFullInformation());

    }



}
