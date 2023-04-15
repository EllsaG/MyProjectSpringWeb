package com.myproject.services.powertransformers.delete;

import com.myproject.controller.dto.powertransformers.postget.PowerTransformersResponseDTO;
import com.myproject.entity.PowerTransformers;
import com.myproject.services.powertransformers.postget.PowerTransformersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerTransformersDeleteService {

    private final PowerTransformersService powerTransformersService;


    @Autowired
    public PowerTransformersDeleteService(PowerTransformersService powerTransformersService) {
        this.powerTransformersService = powerTransformersService;
    }

    public PowerTransformersResponseDTO delete(long idForDelete){
        PowerTransformers informationById = powerTransformersService.getInformationById(idForDelete);
        return powerTransformersService.delete(informationById);
    }

}