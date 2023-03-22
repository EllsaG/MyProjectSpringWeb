package com.myproject.controller.lightinformation.postget;

import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesRequestDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesResponseDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewRequestDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.service.lightinformation.postget.LightInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LightInformationController {


    private final  LightInformationService lightInformationService;

    @Autowired
    public LightInformationController(LightInformationService lightInformationService) {
        this.lightInformationService = lightInformationService;
    }

    @PostMapping("/lightinformation/create/forchooseluminaries")
    public LightInformationChooseLuminariesResponseDTO chooseLuminaries(@RequestBody LightInformationChooseLuminariesRequestDTO lightInformationChooseLuminariesRequestDTO) {
        return lightInformationService.forChooseLuminaries(lightInformationChooseLuminariesRequestDTO.getHeightProductionHall(),
                lightInformationChooseLuminariesRequestDTO.getWidthProductionHall(), lightInformationChooseLuminariesRequestDTO.getLengthProductionHall());

    }

    @PostMapping("/lightinformation/create/insertnewluminaries")
    public LightInformationCreateNewResponseDTO createNew(@RequestBody LightInformationCreateNewRequestDTO lightInformationCreateNewRequestDTO) {
        return lightInformationService.createNew(lightInformationCreateNewRequestDTO.getModelOfLuminaire(),
                lightInformationCreateNewRequestDTO.getModelOfLamp(), lightInformationCreateNewRequestDTO.getAmountOfLampsInOneLuminaire(),
                lightInformationCreateNewRequestDTO.getLightFluxOneLamp(), lightInformationCreateNewRequestDTO.getActivePowerOneLamp());
    }
}
