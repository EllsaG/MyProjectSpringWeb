package com.myproject.controller.powertransformers.delete;

import com.myproject.controller.dto.powertransformers.postget.PowerTransformersResponseDTO;
import com.myproject.services.powertransformers.delete.PowerTransformersDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerTransformersDeleteController {

    private final PowerTransformersDeleteService powerTransformersDeleteService;
    @Autowired
    public PowerTransformersDeleteController(PowerTransformersDeleteService powerTransformersDeleteService) {
        this.powerTransformersDeleteService = powerTransformersDeleteService;
    }



    @DeleteMapping("/powertransformer/delete/{idForDelete}")
    public PowerTransformersResponseDTO deleteInfo(@PathVariable long idForDelete){
        return powerTransformersDeleteService.delete(idForDelete);
    }

}
