package com.myproject.services.powertransformers.postget;

import com.myproject.controller.dto.powertransformers.postget.PowerTransformersResponseDTO;
import com.myproject.entity.PowerTransformers;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.*;
import com.myproject.utils.ChoosingOfTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerTransformersService {

    private final FullInformationRepository fullInformationRepository;
    private final ForChooseTransformersRepository forChooseTransformersRepository;
    private final PowerTransformersRepository powerTransformersRepository;

    @Autowired
    public PowerTransformersService(FullInformationRepository fullInformationRepository, ForChooseTransformersRepository forChooseTransformersRepository,
                                    PowerTransformersRepository powerTransformersRepository) {
        this.fullInformationRepository = fullInformationRepository;
        this.forChooseTransformersRepository = forChooseTransformersRepository;
        this.powerTransformersRepository = powerTransformersRepository;
    }


    public PowerTransformersResponseDTO save(long id, String modelOfTransformer, double fullPowerOfTransformer,
                                             double shortCircuitVoltage, double idleLossesOfTransformer,
                                             double highSideVoltage, double lowSideVoltage, double shortCircuitLosses, double idleCurrent) {


        ChoosingOfTransformers choosingOfTransformers = new ChoosingOfTransformers();
        PowerTransformers newTransformer = choosingOfTransformers.createNewTransformer(id, modelOfTransformer, fullPowerOfTransformer,
                shortCircuitVoltage, idleLossesOfTransformer,highSideVoltage, lowSideVoltage, shortCircuitLosses, idleCurrent,
                 fullInformationRepository, forChooseTransformersRepository);

        powerTransformersRepository.save(newTransformer);

        return new PowerTransformersResponseDTO(getAllInformation());

    }
    public PowerTransformers getInformationById(long id) {
        return powerTransformersRepository.findById(id)
                .orElseThrow(()->new InformationNotFoundException("Unable to find information about power transformer with id № " + id));
    }
    public List<PowerTransformers> getAllInformation() {
        return powerTransformersRepository.findAll();
    }


    public PowerTransformersResponseDTO delete(PowerTransformers powerTransformers) {
        powerTransformersRepository.delete(powerTransformers);
        return new PowerTransformersResponseDTO(getAllInformation());
    }

    public PowerTransformersResponseDTO update(long id, String modelOfTransformer, double fullPowerOfTransformer,
                                               double shortCircuitVoltage, double idleLossesOfTransformer,
                                               double highSideVoltage, double lowSideVoltage, double shortCircuitLosses, double idleCurrent) {

        return save(id, modelOfTransformer, fullPowerOfTransformer,shortCircuitVoltage,
                idleLossesOfTransformer,highSideVoltage, lowSideVoltage, shortCircuitLosses, idleCurrent);
    }

}
