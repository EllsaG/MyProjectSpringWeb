package com.myproject.services.highvoltcables.postget;

import com.myproject.controller.dto.highvoltcable.postget.ChooseHighVoltCablesResponseDTO;
import com.myproject.controller.dto.highvoltcable.postget.HighVoltCablesResponseDTO;
import com.myproject.entity.*;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.HighVoltCablesRepository;
import com.myproject.repositories.LowVoltCablesRepository;
import com.myproject.repositories.ForChooseHighVoltCableRepository;
import com.myproject.repositories.HighVoltInformationRepository;
import com.myproject.utils.HighVoltCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighVoltCablesService {

    private final ForChooseHighVoltCableRepository forChooseHighVoltCableRepository;
    private final HighVoltInformationRepository highVoltInformationRepository;
    private final HighVoltCablesRepository highVoltCablesRepository;

    @Autowired
    public HighVoltCablesService(ForChooseHighVoltCableRepository forChooseHighVoltCableRepository,
                                 HighVoltInformationRepository highVoltInformationRepository,
                                  HighVoltCablesRepository highVoltCablesRepository) {
        this.forChooseHighVoltCableRepository = forChooseHighVoltCableRepository;
        this.highVoltInformationRepository = highVoltInformationRepository;
        this.highVoltCablesRepository = highVoltCablesRepository;
    }


    public ChooseHighVoltCablesResponseDTO forChooseHighVoltCables(long id, double productionHallTransformerFullPower, int baseVoltage, int baseFullPower,
                                                             double relativeBaselineUnrestrictedPowerResistance,
                                                             double highVoltageAirLineLength, double headTransformerFullPower, double shortCircuitVoltage,
                                                             double cableLineLength, double ratedVoltageOfHigherVoltageWindingOfTransformer,
                                                             List<InductiveImpedanceAreas> inductiveImpedanceAreas) {

        HighVoltCalculation highVoltCalculation = new HighVoltCalculation();
        HighVoltInformation highVoltInformation = highVoltCalculation.shortCircuitCurrentCalculation(id, productionHallTransformerFullPower, baseVoltage, baseFullPower,
                relativeBaselineUnrestrictedPowerResistance, highVoltageAirLineLength, headTransformerFullPower, shortCircuitVoltage,
                cableLineLength, ratedVoltageOfHigherVoltageWindingOfTransformer, inductiveImpedanceAreas);

        ForChooseHighVoltCable forChooseHighVoltCable = highVoltCalculation.forChooseHighVoltCable(highVoltInformation);

        forChooseHighVoltCableRepository.save(forChooseHighVoltCable);
        highVoltInformationRepository.save(highVoltInformation);

        return new ChooseHighVoltCablesResponseDTO(getAllHighVoltCables());

    }

    public HighVoltCablesResponseDTO createNewCable(long id,String cableType){
        HighVoltCalculation highVoltCalculation = new HighVoltCalculation();
        HighVoltCables newHighVoltCable = highVoltCalculation.createNewHighVoltCable(id, cableType, highVoltInformationRepository);
        highVoltCablesRepository.save(newHighVoltCable);
        return new HighVoltCablesResponseDTO(getAllHighVoltInformation(),getAllForChoosePowerTransformers());
    }

    public ChooseHighVoltCablesResponseDTO deleteCableById(long id){
        highVoltCablesRepository.deleteById(id);
        return new ChooseHighVoltCablesResponseDTO(getAllHighVoltCables());
    }

    public HighVoltCablesResponseDTO deleteHighVoltInfoById(long id){
        highVoltCablesRepository.deleteById(id);
        return new HighVoltCablesResponseDTO(getAllHighVoltInformation(),getAllForChoosePowerTransformers());
    }


    public ChooseHighVoltCablesResponseDTO updateForChooseHighVoltCables(long id, double productionHallTransformerFullPower, int baseVoltage, int baseFullPower,
                                                                   double relativeBaselineUnrestrictedPowerResistance,
                                                                   double highVoltageAirLineLength, double headTransformerFullPower, double shortCircuitVoltage,
                                                                   double cableLineLength, double ratedVoltageOfHigherVoltageWindingOfTransformer,
                                                                   List<InductiveImpedanceAreas> inductiveImpedanceAreas) {

        return forChooseHighVoltCables(id, productionHallTransformerFullPower, baseVoltage, baseFullPower,
                relativeBaselineUnrestrictedPowerResistance, highVoltageAirLineLength, headTransformerFullPower, shortCircuitVoltage,
                cableLineLength, ratedVoltageOfHigherVoltageWindingOfTransformer, inductiveImpedanceAreas);

    }
    public HighVoltCablesResponseDTO updateCable(long id,String cableType){
        return createNewCable(id, cableType);
    }


    public HighVoltInformation getInformationById(long id) {
        return highVoltInformationRepository.findById(id)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about calculation with id № " + id));
    }

    public List<HighVoltInformation> getAllHighVoltInformation() {
        return highVoltInformationRepository.findAll();
    }

    public List<ForChooseHighVoltCable> getAllForChoosePowerTransformers() {
        return forChooseHighVoltCableRepository.findAll();
    }
    public List<HighVoltCables> getAllHighVoltCables() {
        return highVoltCablesRepository.findAll();
    }


}
