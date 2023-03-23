package com.myproject.service.lightinformation.update;

import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesResponseDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.entity.LightInformation;
import com.myproject.service.lightinformation.postget.LightInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static com.myproject.utils.ForLightingCalculation.electricCalculation;
import static com.myproject.utils.ForLightingCalculation.lightingCalculation;

@Service
public class LightInformationUpdateService {

    private final LightInformationService lightInformationService;

    @Autowired
    public LightInformationUpdateService(LightInformationService lightInformationService) {
        this.lightInformationService = lightInformationService;
    }

    public LightInformationChooseLuminariesResponseDTO forChooseLuminaries(double heightProductionHall, double widthProductionHall, double lengthProductionHall) {
        return lightInformationService.forChooseLuminaries(heightProductionHall, widthProductionHall, lengthProductionHall);
    }

    public LightInformationCreateNewResponseDTO update(long lightInformId, String modelOfLuminaire, String modelOfLamp, int amountOfLampsInOneLuminaire,
                                                          double lightFluxOneLamp, double activePowerOneLamp) {
        LightInformation lightInformationById = lightInformationService.getLightInformationById(lightInformId);
        lightInformationService.deleteById(lightInformationById);
        return lightInformationService.createNew(modelOfLuminaire, modelOfLamp, lightFluxOneLamp, amountOfLampsInOneLuminaire, activePowerOneLamp);
    }


}
