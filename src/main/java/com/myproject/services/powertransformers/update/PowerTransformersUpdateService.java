package com.myproject.services.powertransformers.update;

import com.myproject.controller.dto.powertransformers.postget.PowerTransformersResponseDTO;
import com.myproject.entity.PowerTransformers;
import com.myproject.services.powertransformers.postget.PowerTransformersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerTransformersUpdateService {

    private final PowerTransformersService powerTransformersService;

    @Autowired
    public PowerTransformersUpdateService(PowerTransformersService powerTransformersService) {
        this.powerTransformersService = powerTransformersService;
    }

    public PowerTransformersResponseDTO update(long id, String modelOfTransformer, double fullPowerOfTransformer,
                                               double shortCircuitVoltage, double idleLossesOfTransformer,
                                               double highSideVoltage, double lowSideVoltage, double shortCircuitLosses, double idleCurrent) {
        PowerTransformers informationById = powerTransformersService.getInformationById(id);
        powerTransformersService.delete(informationById);
        return powerTransformersService.update(id, modelOfTransformer, fullPowerOfTransformer,shortCircuitVoltage,
                idleLossesOfTransformer,highSideVoltage, lowSideVoltage, shortCircuitLosses, idleCurrent);
    }


}
