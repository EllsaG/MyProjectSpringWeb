package com.myproject.service.lightinformation.postget;

import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesResponseDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.entity.FullInformation;
import com.myproject.entity.LightInformation;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.LightInformationRepository;
import com.myproject.service.fullinformation.postget.FullInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import static com.myproject.utils.ForLightingCalculation.electricCalculation;
import static com.myproject.utils.ForLightingCalculation.lightingCalculation;

@Service
public class LightInformationService {

    private final LightInformationRepository lightInformationRepository;
    private final FullInformationService fullInformationService;

    @Autowired

    public LightInformationService(LightInformationRepository lightInformationRepository, FullInformationService fullInformationService) {
        this.lightInformationRepository = lightInformationRepository;
        this.fullInformationService = fullInformationService;
    }


    public LightInformationChooseLuminariesResponseDTO forChooseLuminaries(double heightProductionHall, double widthProductionHall, double lengthProductionHall) {
        HashMap<Integer, HashMap<Double, Double>> integerHashMapHashMap = lightingCalculation(heightProductionHall, widthProductionHall, lengthProductionHall);
        return new LightInformationChooseLuminariesResponseDTO(integerHashMapHashMap);
    }

    public LightInformation getLightInformationById(Long lightInformId) {
        return lightInformationRepository.findById(lightInformId)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about equipment with id № " + lightInformId));
    }

    public List<LightInformation> getAllLightInformation() {
        return lightInformationRepository.findAll();
    }


    public LightInformationCreateNewResponseDTO createNew(Long lightingId,String modelOfLuminaire, String modelOfLamp, double lightFluxOneLamp,
                                                          int amountOfLampsInOneLuminaire, double activePowerOneLamp) {
        LightInformation lightInformation = electricCalculation(lightingId, modelOfLuminaire, modelOfLamp, lightFluxOneLamp, amountOfLampsInOneLuminaire, activePowerOneLamp);
        lightInformationRepository.save(lightInformation);

        FullInformation fullInformation = new FullInformation();
        fullInformation.setId(lightingId);
        fullInformation.setNameOfBusbar("Освещение");
        fullInformation.setAmount(lightInformation.getAmountOfLuminaires()*lightInformation.getAmountOfLampsInOneLuminaire());
        fullInformation.setAvgDailyActivePower(lightInformation.getActivePower());
        fullInformation.setAvgDailyReactivePower(lightInformation.getReactivePower());
        fullInformation.setEffectiveAmountOfEquipment(0);
        fullInformation.setCoefficientMax(0.0);
        fullInformation.setMaxActivePower(lightInformation.getActivePower());
        fullInformation.setMaxReactivePower(lightInformation.getReactivePower());
        fullInformation.setMaxFullPower(lightInformation.getFullPower());
        fullInformation.setMaxElectricCurrent(lightInformation.getElectricCurrent());
        fullInformation.setPowerOfGroup(lightInformation.getPowerOfOneLamp());
        fullInformation.setCosF(lightInformation.getCosF());
        fullInformation.setTgF(lightInformation.getTgF());
        fullInformation.setKi(0.0);
        fullInformation.setModule(0.0);



        fullInformationService.saveLighting(fullInformation);

        return new LightInformationCreateNewResponseDTO(getAllLightInformation());
    }

    public LightInformationCreateNewResponseDTO deleteById(LightInformation lightInformation) {
        lightInformationRepository.delete(lightInformation);
        return new LightInformationCreateNewResponseDTO(getAllLightInformation());

    }

    public LightInformationCreateNewResponseDTO update(long lightingId,String modelOfLuminaire, String modelOfLamp, int amountOfLampsInOneLuminaire,
                                                       double lightFluxOneLamp, double activePowerOneLamp) {
        LightInformation lightInformation = electricCalculation(lightingId, modelOfLuminaire, modelOfLamp, lightFluxOneLamp, amountOfLampsInOneLuminaire, activePowerOneLamp);
        lightInformationRepository.save(lightInformation);

        return new LightInformationCreateNewResponseDTO(getAllLightInformation());
    }


}
