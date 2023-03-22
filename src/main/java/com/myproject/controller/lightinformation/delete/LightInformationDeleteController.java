package com.myproject.controller.lightinformation.delete;

import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.service.lightinformation.delete.LightInformationDeleteService;
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
    public LightInformationCreateNewResponseDTO deleteById(@PathVariable Long lightInformId){
        return lightInformationDeleteService.deleteById(lightInformId);
    }



}
