package com.myproject.controller.powertransformers.update;

import com.myproject.controller.dto.powertransformers.postget.PowerTransformersResponseDTO;
import com.myproject.controller.dto.powertransformers.update.PowerTransformersUpdateRequestDTO;
import com.myproject.services.powertransformers.update.PowerTransformersUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerTransformersUpdateController {
    private final PowerTransformersUpdateService powerTransformersUpdateService;
@Autowired
    public PowerTransformersUpdateController(PowerTransformersUpdateService powerTransformersUpdateService) {
        this.powerTransformersUpdateService = powerTransformersUpdateService;
    }

    @PostMapping("/powertransformer/update")
    public PowerTransformersResponseDTO update(@RequestBody PowerTransformersUpdateRequestDTO powerTransformersUpdateRequestDTO){
        return powerTransformersUpdateService.update(powerTransformersUpdateRequestDTO.getId(), powerTransformersUpdateRequestDTO.getModelOfTransformer(),
                powerTransformersUpdateRequestDTO.getFullPowerOfTransformer(), powerTransformersUpdateRequestDTO.getShortCircuitVoltage(),
                powerTransformersUpdateRequestDTO.getIdleLossesOfTransformer(),powerTransformersUpdateRequestDTO.getHighSideVoltage(),
                powerTransformersUpdateRequestDTO.getLowSideVoltage(),powerTransformersUpdateRequestDTO.getShortCircuitLosses(),
                powerTransformersUpdateRequestDTO.getIdleCurrent());
    }
}
