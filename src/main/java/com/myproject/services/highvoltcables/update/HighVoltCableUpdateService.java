package com.myproject.services.highvoltcables.update;

import com.myproject.controller.dto.highvoltcable.postget.ChooseHighVoltCablesResponseDTO;
import com.myproject.controller.dto.highvoltcable.postget.HighVoltCablesResponseDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesResponseDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.entity.*;
import com.myproject.services.highvoltcables.postget.HighVoltCablesService;
import com.myproject.services.lightinformation.postget.LightInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HighVoltCableUpdateService {

    private final HighVoltCablesService highVoltCablesService;

    @Autowired
    public HighVoltCableUpdateService(HighVoltCablesService highVoltCablesService) {
        this.highVoltCablesService = highVoltCablesService;
    }

    public ChooseHighVoltCablesResponseDTO updateForChooseHighVoltCables(long id, double productionHallTransformerFullPower, int baseVoltage, int baseFullPower,
                                                                   double relativeBaselineUnrestrictedPowerResistance,
                                                                   double highVoltageAirLineLength, double headTransformerFullPower, double shortCircuitVoltage,
                                                                   double cableLineLength, double ratedVoltageOfHigherVoltageWindingOfTransformer,
                                                                   List<InductiveImpedanceAreas> inductiveImpedanceAreas) {
        HighVoltInformation informationById = highVoltCablesService.getInformationById(id);
        highVoltCablesService.deleteHighVoltInfoById(informationById);
        return highVoltCablesService.updateForChooseHighVoltCables(id, productionHallTransformerFullPower, baseVoltage, baseFullPower,
                relativeBaselineUnrestrictedPowerResistance, highVoltageAirLineLength, headTransformerFullPower, shortCircuitVoltage,
                cableLineLength, ratedVoltageOfHigherVoltageWindingOfTransformer, inductiveImpedanceAreas);
    }

    public HighVoltCablesResponseDTO updateCable(long id, String cableType) {
        HighVoltCables cableById = highVoltCablesService.getCableById(id);
        highVoltCablesService.deleteCableById(cableById);
        return highVoltCablesService.updateCable( id, cableType);
    }


}
