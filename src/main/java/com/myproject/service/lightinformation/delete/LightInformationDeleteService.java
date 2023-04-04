package com.myproject.service.lightinformation.delete;

import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.entity.LightInformation;
import com.myproject.service.lightinformation.postget.LightInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LightInformationDeleteService {

    private final LightInformationService lightInformationService;

    @Autowired
    public LightInformationDeleteService(LightInformationService lightInformationService) {
        this.lightInformationService = lightInformationService;
    }

    public LightInformationCreateNewResponseDTO deleteById(long lightInformId) {
        LightInformation lightInformationById = lightInformationService.getLightInformationById(lightInformId);
        return lightInformationService.deleteById(lightInformationById);
    }

}
