package com.myproject.controller.lightinformation.postget;

import com.myproject.controller.dto.lightinformation.postget.LightInformationRequestDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationResponseDTO;
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

    @PostMapping("/lightinformatin/create/forchooseluminaries")
    public LightInformationResponseDTO create(@RequestBody LightInformationRequestDTO lightInformationRequestDTO) {
        return lightInformationService.forChooseLuminaries(lightInformationRequestDTO.getHeightProductionHall(),
                lightInformationRequestDTO.getWidthProductionHall(), lightInformationRequestDTO.getLengthProductionHall());

    }


}
