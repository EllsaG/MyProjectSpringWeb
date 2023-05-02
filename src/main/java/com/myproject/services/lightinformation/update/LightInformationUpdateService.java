package com.myproject.services.lightinformation.update;

import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesResponseDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.entity.ForChooseLuminaire;
import com.myproject.entity.LightInformation;
import com.myproject.services.lightinformation.postget.LightInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LightInformationUpdateService {

    private final LightInformationService lightInformationService;

    @Autowired
    public LightInformationUpdateService(LightInformationService lightInformationService) {
        this.lightInformationService = lightInformationService;
    }

    public LightInformationChooseLuminariesResponseDTO forChooseLuminaries(long lightingId,double heightProductionHall, double widthProductionHall, double lengthProductionHall) {
        ForChooseLuminaire luminaireById = lightInformationService.getLuminaireById(lightingId);
        lightInformationService.deleteLuminaireById(luminaireById);
        return lightInformationService.forChooseLuminaries(lightingId, heightProductionHall, widthProductionHall, lengthProductionHall);
    }

    public LightInformationCreateNewResponseDTO update(long lightInformId, String modelOfLuminaire, String modelOfLamp, int amountOfLampsInOneLuminaire,
                                                          double lightFluxOneLamp, double activePowerOneLamp) {
        LightInformation lightInformationById = lightInformationService.getLightInformationById(lightInformId);
        lightInformationService.deleteById(lightInformationById);
        return lightInformationService.update(lightInformId, modelOfLuminaire, modelOfLamp, lightFluxOneLamp, amountOfLampsInOneLuminaire, activePowerOneLamp);
    }


}
