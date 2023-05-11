package com.myproject.services.highvoltcables.postget;

import com.myproject.controller.dto.highvoltcable.postget.ChooseHighVoltCablesResponseDTO;
import com.myproject.controller.dto.highvoltcable.postget.HighVoltCablesResponseDTO;
import com.myproject.controller.dto.highvoltcable.postget.InductiveResistanceAreasRequestDTO;
import com.myproject.entity.*;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.HighVoltCablesRepository;
import com.myproject.repositories.ForChooseHighVoltCableRepository;
import com.myproject.repositories.HighVoltInformationRepository;
import com.myproject.repositories.PowerTransformersRepository;
import com.myproject.utils.HighVoltCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighVoltCablesService {

    private final ForChooseHighVoltCableRepository forChooseHighVoltCableRepository;
    private final HighVoltInformationRepository highVoltInformationRepository;
    private final HighVoltCablesRepository highVoltCablesRepository;
    private final PowerTransformersRepository powerTransformersRepository;

    @Autowired
    public HighVoltCablesService(ForChooseHighVoltCableRepository forChooseHighVoltCableRepository,
                                 HighVoltInformationRepository highVoltInformationRepository,
                                 HighVoltCablesRepository highVoltCablesRepository, PowerTransformersRepository powerTransformersRepository) {
        this.forChooseHighVoltCableRepository = forChooseHighVoltCableRepository;
        this.highVoltInformationRepository = highVoltInformationRepository;
        this.highVoltCablesRepository = highVoltCablesRepository;
        this.powerTransformersRepository = powerTransformersRepository;
    }


    public ChooseHighVoltCablesResponseDTO forChooseHighVoltCables(long id, int baseVoltage, int baseFullPower,
                                                             double relativeBaselineUnrestrictedPowerResistance,
                                                             double highVoltageAirLineLength, double headTransformerFullPower, double shortCircuitVoltage,
                                                             double cableLineLength, double ratedVoltageOfHigherVoltageWindingOfTransformer,
                                                             List<InductiveResistanceAreasRequestDTO> inductiveResistanceAreasList) {

        HighVoltCalculation highVoltCalculation = new HighVoltCalculation();
        HighVoltInformation highVoltInformation = highVoltCalculation.shortCircuitCurrentCalculation(id, baseVoltage, baseFullPower,
                relativeBaselineUnrestrictedPowerResistance, highVoltageAirLineLength, headTransformerFullPower, shortCircuitVoltage,
                cableLineLength, ratedVoltageOfHigherVoltageWindingOfTransformer, inductiveResistanceAreasList,powerTransformersRepository);

        ForChooseHighVoltCable forChooseHighVoltCable = highVoltCalculation.forChooseHighVoltCable(highVoltInformation);

        forChooseHighVoltCableRepository.save(forChooseHighVoltCable);
        highVoltInformationRepository.save(highVoltInformation);

        return new ChooseHighVoltCablesResponseDTO(getAllForChooseHighVoltCable());

    }

    public HighVoltCablesResponseDTO createNewCable(long id,String cableType){
        HighVoltCalculation highVoltCalculation = new HighVoltCalculation();
        HighVoltCables newHighVoltCable = highVoltCalculation.createNewHighVoltCable(id, cableType, highVoltInformationRepository);
        highVoltCablesRepository.save(newHighVoltCable);
        return new HighVoltCablesResponseDTO(getAllHighVoltInformation(),getAllForChooseHighVoltCable());
    }

    public ChooseHighVoltCablesResponseDTO deleteCableById(HighVoltCables highVoltCables){
        highVoltCablesRepository.delete(highVoltCables);
        return new ChooseHighVoltCablesResponseDTO(getAllForChooseHighVoltCable());
    }

    public HighVoltCablesResponseDTO deleteHighVoltInfoById(HighVoltInformation highVoltInformation, ForChooseHighVoltCable forChooseHighVoltCable){
        highVoltInformationRepository.delete(highVoltInformation);
        forChooseHighVoltCableRepository.delete(forChooseHighVoltCable);
        return new HighVoltCablesResponseDTO(getAllHighVoltInformation(),getAllForChooseHighVoltCable());
    }


    public ChooseHighVoltCablesResponseDTO updateForChooseHighVoltCables(long id, int baseVoltage, int baseFullPower,
                                                                   double relativeBaselineUnrestrictedPowerResistance,
                                                                   double highVoltageAirLineLength, double headTransformerFullPower, double shortCircuitVoltage,
                                                                   double cableLineLength, double ratedVoltageOfHigherVoltageWindingOfTransformer,
                                                                   List<InductiveResistanceAreasRequestDTO> inductiveResistanceAreasList) {

        return forChooseHighVoltCables(id, baseVoltage, baseFullPower,
                relativeBaselineUnrestrictedPowerResistance, highVoltageAirLineLength, headTransformerFullPower, shortCircuitVoltage,
                cableLineLength, ratedVoltageOfHigherVoltageWindingOfTransformer, inductiveResistanceAreasList);

    }
    public HighVoltCablesResponseDTO updateCable(long id,String cableType){
        return createNewCable(id, cableType);
    }


    public HighVoltInformation getInformationById(long id) {
        return highVoltInformationRepository.findById(id)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about calculation with id № " + id));
    }
    public ForChooseHighVoltCable getForChooseCableById(long id) {
        return forChooseHighVoltCableRepository.findById(id)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find  information for cable selection with id № " + id));
    }
    public HighVoltCables getCableById(long id) {
        return highVoltCablesRepository.findById(id)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about high volt cable with id № " + id));
    }

    public List<HighVoltInformation> getAllHighVoltInformation() {
        return highVoltInformationRepository.findAll();
    }

    public List<ForChooseHighVoltCable> getAllForChooseHighVoltCable() {
        return forChooseHighVoltCableRepository.findAll();
    }
    public List<HighVoltCables> getAllHighVoltCables() {
        return highVoltCablesRepository.findAll();
    }


}
