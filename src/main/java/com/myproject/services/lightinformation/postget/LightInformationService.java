package com.myproject.services.lightinformation.postget;

import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesResponseDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.entity.ForChooseLuminaire;
import com.myproject.entity.LightInformation;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.ForChooseLuminaireRepository;
import com.myproject.repositories.LightInformationRepository;
import com.myproject.utils.ForLightingCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LightInformationService {

    private final LightInformationRepository lightInformationRepository;
    private final ForChooseLuminaireRepository forChooseLuminaireRepository;

    @Autowired
    public LightInformationService(LightInformationRepository lightInformationRepository, ForChooseLuminaireRepository forChooseLuminaireRepository) {
        this.lightInformationRepository = lightInformationRepository;
        this.forChooseLuminaireRepository = forChooseLuminaireRepository;
    }

    public LightInformationChooseLuminariesResponseDTO forChooseLuminaries(long lightingId, double heightProductionHall,
                                                                           double widthProductionHall, double lengthProductionHall) {
        ForLightingCalculation forLightingCalculation = new ForLightingCalculation();
        ForChooseLuminaire forChooseLuminaire = forLightingCalculation.lightingCalculation(lightingId,
                heightProductionHall, widthProductionHall, lengthProductionHall, forChooseLuminaireRepository);
        forChooseLuminaireRepository.save(forChooseLuminaire);

        return forLightingCalculation.forResponseChooseLuminaries(forChooseLuminaireRepository);
    }

    public LightInformation getLightInformationById(long lightInformId) {
        return lightInformationRepository.findById(lightInformId)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about lighting with id № " + lightInformId));
    }
    public ForChooseLuminaire getLuminaireById(long luminaireInformId) {
        return forChooseLuminaireRepository.findById(luminaireInformId)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about luminaire with id № " + luminaireInformId));
    }

    public List<LightInformation> getAllLightInformation() {
        return lightInformationRepository.findAll();
    }

    public LightInformationChooseLuminariesResponseDTO getAllForChooseLuminaire() {
        ForLightingCalculation forLightingCalculation = new ForLightingCalculation();
        return forLightingCalculation.forResponseChooseLuminaries(forChooseLuminaireRepository);
    }


    public LightInformationCreateNewResponseDTO createNew(long lightingId, String modelOfLuminaire, String modelOfLamp, double lightFluxOneLamp,
                                                          int amountOfLampsInOneLuminaire, double activePowerOneLamp) {
        ForLightingCalculation forLightingCalculation = new ForLightingCalculation();
        LightInformation lightInformation = forLightingCalculation.electricCalculation(forChooseLuminaireRepository, lightInformationRepository, lightingId, modelOfLuminaire, modelOfLamp, lightFluxOneLamp, amountOfLampsInOneLuminaire, activePowerOneLamp);
        lightInformationRepository.save(lightInformation);

        return new LightInformationCreateNewResponseDTO(getAllLightInformation());
    }

    public LightInformationCreateNewResponseDTO deleteById(LightInformation lightInformation) {
        lightInformationRepository.delete(lightInformation);
        return new LightInformationCreateNewResponseDTO(getAllLightInformation());

    }

    public LightInformationChooseLuminariesResponseDTO deleteLuminaireById(ForChooseLuminaire forChooseLuminaire) {
        forChooseLuminaireRepository.delete(forChooseLuminaire);
        return getAllForChooseLuminaire();

    }

    public LightInformationCreateNewResponseDTO update(long lightingId, String modelOfLuminaire, String modelOfLamp, double lightFluxOneLamp,
                                                       int amountOfLampsInOneLuminaire, double activePowerOneLamp) {
        return createNew(lightingId, modelOfLuminaire, modelOfLamp, lightFluxOneLamp, amountOfLampsInOneLuminaire, activePowerOneLamp);
    }


}
