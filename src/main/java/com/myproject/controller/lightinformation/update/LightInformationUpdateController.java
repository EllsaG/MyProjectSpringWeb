package com.myproject.controller.lightinformation.update;

import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesRequestDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesResponseDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewRequestDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.controller.dto.lightinformation.update.LightInformationUpdateRequestDTO;
import com.myproject.service.lightinformation.update.LightInformationUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LightInformationUpdateController {

    private final LightInformationUpdateService lightInformationUpdateService;

    @Autowired
    public LightInformationUpdateController(LightInformationUpdateService lightInformationUpdateService) {
        this.lightInformationUpdateService = lightInformationUpdateService;
    }

    @PostMapping("/lightinformation/update/forchooseluminaries")
    public LightInformationChooseLuminariesResponseDTO chooseLuminaries(@RequestBody LightInformationChooseLuminariesRequestDTO lightInformationChooseLuminariesRequestDTO) {
        return lightInformationUpdateService.forChooseLuminaries(lightInformationChooseLuminariesRequestDTO.getHeightProductionHall(),
                lightInformationChooseLuminariesRequestDTO.getWidthProductionHall(), lightInformationChooseLuminariesRequestDTO.getLengthProductionHall());

    }

    @PostMapping("/lightinformation/update/insertnewluminaries")
    public LightInformationCreateNewResponseDTO update(@RequestBody LightInformationUpdateRequestDTO lightInformationUpdateRequestDTO) {
        return lightInformationUpdateService.update(lightInformationUpdateRequestDTO.getLightingId(), lightInformationUpdateRequestDTO.getModelOfLuminaire(),
                lightInformationUpdateRequestDTO.getModelOfLamp(), lightInformationUpdateRequestDTO.getAmountOfLampsInOneLuminaire(),
                lightInformationUpdateRequestDTO.getLightFluxOneLamp(), lightInformationUpdateRequestDTO.getActivePowerOneLamp());
    }
}
