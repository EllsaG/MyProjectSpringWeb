package com.myproject.service.lightinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesResponseDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.entity.LightInformation;
import com.myproject.entity.StartInformation;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.LightInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import static com.myproject.utils.ForLightingCalculation.electricCalculation;
import static com.myproject.utils.ForLightingCalculation.lightingCalculation;

@Service
public class LightInformationService {

    private final LightInformationRepository lightInformationRepository;

    @Autowired
    public LightInformationService(LightInformationRepository lightInformationRepository) {
        this.lightInformationRepository = lightInformationRepository;
    }

    public LightInformationChooseLuminariesResponseDTO forChooseLuminaries(double heightProductionHall, double widthProductionHall, double lengthProductionHall) {
        HashMap<Integer, HashMap<Double, Double>> integerHashMapHashMap = lightingCalculation(heightProductionHall, widthProductionHall, lengthProductionHall);
        return new LightInformationChooseLuminariesResponseDTO(integerHashMapHashMap);
    }
    public LightInformation getLightInformationById(Long lightInformId) {
        return lightInformationRepository.findById(lightInformId)
                .orElseThrow(()->new InformationNotFoundException("Unable to find information about equipment with id № " + lightInformId));
    }
    public List<LightInformation> getAllLightInformation() {
        return lightInformationRepository.findAll();
    }


    public LightInformationCreateNewResponseDTO createNew(String modelOfLuminaire, String modelOfLamp, int amountOfLampsInOneLuminaire,
                                                          double lightFluxOneLamp, double activePowerOneLamp) {
        LightInformation lightInformation = electricCalculation(modelOfLuminaire, modelOfLamp, lightFluxOneLamp, amountOfLampsInOneLuminaire, activePowerOneLamp);
        lightInformationRepository.save(lightInformation);

        return new LightInformationCreateNewResponseDTO(getAllLightInformation());
    }
    public LightInformationCreateNewResponseDTO deleteById(LightInformation lightInformation ){
        lightInformationRepository.delete(lightInformation);
        return  new LightInformationCreateNewResponseDTO(getAllLightInformation());

    }


}
