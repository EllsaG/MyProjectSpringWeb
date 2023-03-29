package com.myproject.controller.lightinformation.postget;

import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesRequestDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesResponseDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewRequestDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.service.lightinformation.postget.LightInformationService;
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
    @GetMapping("/lightinformation/all")
    public LightInformationCreateNewResponseDTO getAll(){
        return new LightInformationCreateNewResponseDTO(lightInformationService.getAllLightInformation());

    }

    @PostMapping("/lightinformation/create/forchooseluminaires")
    public LightInformationChooseLuminariesResponseDTO chooseLuminaries(@RequestBody LightInformationChooseLuminariesRequestDTO lightInformationChooseLuminariesRequestDTO) {
        LightInformationChooseLuminariesResponseDTO lightInformationChooseLuminariesResponseDTO = lightInformationService.forChooseLuminaries(lightInformationChooseLuminariesRequestDTO.getHeightProductionHall(),
                lightInformationChooseLuminariesRequestDTO.getWidthProductionHall(), lightInformationChooseLuminariesRequestDTO.getLengthProductionHall());
        return lightInformationChooseLuminariesResponseDTO;

    }

    @PostMapping("/lightinformation/create/createnewlighting")
    public LightInformationCreateNewResponseDTO createNew(@RequestBody LightInformationCreateNewRequestDTO lightInformationCreateNewRequestDTO) {
        return lightInformationService.createNew(lightInformationCreateNewRequestDTO.getLightingId(),lightInformationCreateNewRequestDTO.getModelOfLuminaire(),
                lightInformationCreateNewRequestDTO.getModelOfLamp(), lightInformationCreateNewRequestDTO.getLightFluxOneLamp(),
                lightInformationCreateNewRequestDTO.getAmountOfLampsInOneLuminaire(),
                lightInformationCreateNewRequestDTO.getActivePowerOneLamp());
    }
}
