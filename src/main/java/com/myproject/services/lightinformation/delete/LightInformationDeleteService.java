package com.myproject.services.lightinformation.delete;

import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesResponseDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.entity.ForChooseLuminaire;
import com.myproject.entity.LightInformation;
import com.myproject.services.lightinformation.postget.LightInformationService;
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
    public LightInformationChooseLuminariesResponseDTO deleteLuminaireById(long lightInformId) {
        ForChooseLuminaire luminaireById = lightInformationService.getLuminaireById(lightInformId);
        return lightInformationService.deleteLuminareById(luminaireById);
    }

}
