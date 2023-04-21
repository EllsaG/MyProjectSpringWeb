package com.myproject.controller.powertransformers.postget;

import com.myproject.controller.dto.powertransformers.postget.PowerTransformersRequestDTO;
import com.myproject.controller.dto.powertransformers.postget.PowerTransformersResponseDTO;
import com.myproject.services.powertransformers.postget.PowerTransformersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerTransformersController {

    private final PowerTransformersService powerTransformersService;

    @Autowired
    public PowerTransformersController(PowerTransformersService powerTransformersService) {
        this.powerTransformersService = powerTransformersService;
    }


    @GetMapping("/powertransformer/all")
    public PowerTransformersResponseDTO getAll(){
        return new PowerTransformersResponseDTO(powerTransformersService.getAllPowerTransformers(),
                powerTransformersService.getAllForChoosePowerTransformers());
    }

    @PostMapping("/powertransformer/create")
    public PowerTransformersResponseDTO save(@RequestBody PowerTransformersRequestDTO powerTransformersRequestDTO) {
        return powerTransformersService.save(powerTransformersRequestDTO.getId(), powerTransformersRequestDTO.getModelOfTransformer(),
                powerTransformersRequestDTO.getFullPowerOfTransformer(), powerTransformersRequestDTO.getShortCircuitVoltage(),
                powerTransformersRequestDTO.getIdleLossesOfTransformer(),powerTransformersRequestDTO.getHighSideVoltage(),
                powerTransformersRequestDTO.getLowSideVoltage(),powerTransformersRequestDTO.getShortCircuitLosses(),
                powerTransformersRequestDTO.getIdleCurrent());
    }



}
