package com.myproject.service.lightinformation.postget;

import com.myproject.controller.dto.lightinformation.postget.LightInformationResponseDTO;
import com.myproject.repositories.LightInformationRepository;
import com.myproject.utils.ForLightingCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static com.myproject.utils.ForLightingCalculation.lightingCalculation;

@Service
public class LightInformationService {

    private final LightInformationRepository lightInformationRepository;
@Autowired
    public LightInformationService(LightInformationRepository lightInformationRepository) {
        this.lightInformationRepository = lightInformationRepository;
    }

    public LightInformationResponseDTO forChooseLuminaries(double heightProductionHall, double widthProductionHall, double lengthProductionHall){
        HashMap<Integer, HashMap<Double, Double>> integerHashMapHashMap = lightingCalculation(heightProductionHall, widthProductionHall, lengthProductionHall);
        return new LightInformationResponseDTO(integerHashMapHashMap);
    }


}
