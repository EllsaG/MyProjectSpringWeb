package com.myproject.controller.lightinformation.postget;

import com.myproject.controller.dto.lightinformation.postget.*;
import com.myproject.services.lightinformation.postget.LightInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LightInformationController {


    private final LightInformationService lightInformationService;

    @Autowired
    public LightInformationController(LightInformationService lightInformationService) {
        this.lightInformationService = lightInformationService;
    }
    @GetMapping("/lightinformation/forchooseluminaires/all")
    public LightInformationChooseLuminariesResponseDTO getAllForChooseLuminaries(){
        return lightInformationService.getAllForChooseLuminaire();
    }

    @GetMapping("/lightinformation/lightinformation/all")
    public LightInformationCreateNewResponseDTO getAllLightingInformation(){
        return new LightInformationCreateNewResponseDTO(lightInformationService.getAllLightInformation());
    }

    @PostMapping("/lightinformation/create/forchooseluminaires")
    public LightInformationChooseLuminariesResponseDTO chooseLuminaries(@RequestBody LightInformationChooseLuminariesRequestDTO lightInformationChooseLuminariesRequestDTO) {
        return lightInformationService.forChooseLuminaries(lightInformationChooseLuminariesRequestDTO.getLightingId(),
                lightInformationChooseLuminariesRequestDTO.getHeightProductionHall(),
                lightInformationChooseLuminariesRequestDTO.getWidthProductionHall(), lightInformationChooseLuminariesRequestDTO.getLengthProductionHall());

    }

    @PostMapping("/lightinformation/create/createnewlighting")
    public LightInformationCreateNewResponseDTO createNew(@RequestBody LightInformationCreateNewRequestDTO lightInformationCreateNewRequestDTO) {
        return lightInformationService.createNew(lightInformationCreateNewRequestDTO.getLightingId(),lightInformationCreateNewRequestDTO.getModelOfLuminaire(),
                lightInformationCreateNewRequestDTO.getModelOfLamp(), lightInformationCreateNewRequestDTO.getLightFluxOneLamp(),
                lightInformationCreateNewRequestDTO.getAmountOfLampsInOneLuminaire(),
                lightInformationCreateNewRequestDTO.getActivePowerOneLamp());
    }
}
