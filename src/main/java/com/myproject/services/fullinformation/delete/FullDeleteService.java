package com.myproject.services.fullinformation.delete;

import com.myproject.controller.dto.fullinformation.postget.FullInformationResponseDTO;
import com.myproject.entity.FullInformation;
import com.myproject.services.fullinformation.postget.FullInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FullDeleteService {

    FullInformationService fullInformationService;
@Autowired
    public FullDeleteService(FullInformationService fullInformationService) {
        this.fullInformationService = fullInformationService;
    }

    public FullInformationResponseDTO deleteInfoById(long id){
        FullInformation informationById = fullInformationService.getInformationById(id);

        fullInformationService.delete(informationById);
        return new FullInformationResponseDTO(fullInformationService.getAllFullInformation());

    }



}
