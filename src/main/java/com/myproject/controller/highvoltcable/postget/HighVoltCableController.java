package com.myproject.controller.highvoltcable.postget;

import com.myproject.controller.dto.highvoltcable.postget.ChooseHighVoltCablesRequestDTO;
import com.myproject.controller.dto.highvoltcable.postget.ChooseHighVoltCablesResponseDTO;
import com.myproject.controller.dto.highvoltcable.postget.HighVoltCablesRequestDTO;
import com.myproject.controller.dto.highvoltcable.postget.HighVoltCablesResponseDTO;
import com.myproject.services.highvoltcables.postget.HighVoltCablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HighVoltCableController {


    private final HighVoltCablesService highVoltCablesService;

    @Autowired
    public HighVoltCableController(HighVoltCablesService highVoltCablesService) {
        this.highVoltCablesService = highVoltCablesService;
    }
    @GetMapping("/highvoltcable/forchoosehighvoltcales/all")
    public ChooseHighVoltCablesResponseDTO getAllForChooseHighVoltCable(){
        return new ChooseHighVoltCablesResponseDTO(highVoltCablesService.getAllForChooseHighVoltCable());
    }

    @GetMapping("/highvoltcable/highvoltcable/all")
    public HighVoltCablesResponseDTO getAllHighVoltCable(){
        return new HighVoltCablesResponseDTO(highVoltCablesService.getAllHighVoltInformation(),
                highVoltCablesService.getAllForChooseHighVoltCable());
    }

    @PostMapping("/highvoltcable/create/forchoosehighvoltcales")
    public ChooseHighVoltCablesResponseDTO chooseHighVoltCables(@RequestBody HighVoltCablesRequestDTO highVoltCablesRequestDTO) {
        return highVoltCablesService.forChooseHighVoltCables(highVoltCablesRequestDTO.getId(),
                highVoltCablesRequestDTO.getBaseVoltage(),highVoltCablesRequestDTO.getBaseFullPower(),
                highVoltCablesRequestDTO.getRelativeBaselineUnrestrictedPowerResistance(),highVoltCablesRequestDTO.getHighVoltageAirLineLength(),
                highVoltCablesRequestDTO.getHeadTransformerFullPower(),highVoltCablesRequestDTO.getShortCircuitVoltage(),
                highVoltCablesRequestDTO.getCableLineLength(),highVoltCablesRequestDTO.getRatedVoltageOfHigherVoltageWindingOfTransformer(),
                highVoltCablesRequestDTO.getInductiveResistanceAreasList());

    }

    @PostMapping("/highvoltcable/create/createnewhighvoltcales")
    public HighVoltCablesResponseDTO createNew(@RequestBody ChooseHighVoltCablesRequestDTO chooseHighVoltCablesRequestDTO) {
        return highVoltCablesService.createNewCable(chooseHighVoltCablesRequestDTO.getId(),chooseHighVoltCablesRequestDTO.getCableType());
    }
}
