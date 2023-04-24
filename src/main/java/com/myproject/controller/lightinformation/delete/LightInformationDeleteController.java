package com.myproject.controller.lightinformation.delete;

import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesResponseDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.services.lightinformation.delete.LightInformationDeleteService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LightInformationDeleteController {

    private final LightInformationDeleteService lightInformationDeleteService;

    public LightInformationDeleteController(LightInformationDeleteService lightInformationDeleteService) {
        this.lightInformationDeleteService = lightInformationDeleteService;
    }
    @DeleteMapping("/lightinformatiion/delete/{lightInformId}")
    public LightInformationCreateNewResponseDTO deleteLightingById(@PathVariable long lightInformId){
        return lightInformationDeleteService.deleteById(lightInformId);
    }
    @DeleteMapping("/lightinformatiion/delete/forchooseluminaires/{lightInformId}")
    public LightInformationChooseLuminariesResponseDTO deleteLuminaireById(@PathVariable long lightInformId){
        return lightInformationDeleteService.deleteLuminaireById(lightInformId);
    }


}
