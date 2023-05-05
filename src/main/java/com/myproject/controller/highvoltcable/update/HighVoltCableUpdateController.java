package com.myproject.controller.highvoltcable.update;

import com.myproject.controller.dto.highvoltcable.postget.ChooseHighVoltCablesRequestDTO;
import com.myproject.controller.dto.highvoltcable.postget.ChooseHighVoltCablesResponseDTO;
import com.myproject.controller.dto.highvoltcable.postget.HighVoltCablesRequestDTO;
import com.myproject.controller.dto.highvoltcable.postget.HighVoltCablesResponseDTO;
import com.myproject.controller.dto.highvoltcable.update.ChooseHighVoltCablesUpdateRequestDTO;
import com.myproject.controller.dto.highvoltcable.update.HighVoltCablesUpdateRequestDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesRequestDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesResponseDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.controller.dto.lightinformation.update.LightInformationUpdateRequestDTO;
import com.myproject.services.highvoltcables.postget.HighVoltCablesService;
import com.myproject.services.highvoltcables.update.HighVoltCableUpdateService;
import com.myproject.services.lightinformation.update.LightInformationUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HighVoltCableUpdateController {

    private final HighVoltCableUpdateService highVoltCableUpdateService;

    @Autowired
    public HighVoltCableUpdateController(HighVoltCableUpdateService highVoltCableUpdateService) {
        this.highVoltCableUpdateService = highVoltCableUpdateService;
    }

    @PostMapping("/highvoltcable/update/forchoosehighvoltcales")
    public ChooseHighVoltCablesResponseDTO chooseHighVoltCables(@RequestBody HighVoltCablesUpdateRequestDTO highVoltCablesUpdateRequestDTO) {
        return highVoltCableUpdateService.updateForChooseHighVoltCables(highVoltCablesUpdateRequestDTO.getId(),highVoltCablesUpdateRequestDTO.getHeadTransformerFullPower(),
                highVoltCablesUpdateRequestDTO.getBaseVoltage(),highVoltCablesUpdateRequestDTO.getBaseFullPower(),
                highVoltCablesUpdateRequestDTO.getRelativeBaselineUnrestrictedPowerResistance(),highVoltCablesUpdateRequestDTO.getHighVoltageAirLineLength(),
                highVoltCablesUpdateRequestDTO.getHeadTransformerFullPower(),highVoltCablesUpdateRequestDTO.getShortCircuitVoltage(),
                highVoltCablesUpdateRequestDTO.getCableLineLength(),highVoltCablesUpdateRequestDTO.getRatedVoltageOfHigherVoltageWindingOfTransformer(),
                highVoltCablesUpdateRequestDTO.getInductiveImpedanceAreas());

    }

    @PostMapping("/highvoltcable/update/createnewhighvoltcales")
    public HighVoltCablesResponseDTO createNew(@RequestBody ChooseHighVoltCablesUpdateRequestDTO chooseHighVoltCablesUpdateRequestDTO) {
        return highVoltCableUpdateService.updateCable(chooseHighVoltCablesUpdateRequestDTO.getId(),
                chooseHighVoltCablesUpdateRequestDTO.getCableType());
    }

}
