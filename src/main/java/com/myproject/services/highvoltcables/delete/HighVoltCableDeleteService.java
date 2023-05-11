package com.myproject.services.highvoltcables.delete;

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
public class HighVoltCableDeleteService {

    private final HighVoltCablesService highVoltCablesService;

    @Autowired
    public HighVoltCableDeleteService(HighVoltCablesService highVoltCablesService) {
        this.highVoltCablesService = highVoltCablesService;
    }

    public ChooseHighVoltCablesResponseDTO deleteCableById(long id) {
        HighVoltCables cableById = highVoltCablesService.getCableById(id);
        return highVoltCablesService.deleteCableById(cableById);
    }
    public HighVoltCablesResponseDTO deleteHighVoltInfoById(long id) {
        HighVoltInformation informationById = highVoltCablesService.getInformationById(id);
        ForChooseHighVoltCable forChooseCableById = highVoltCablesService.getForChooseCableById(id);
        return highVoltCablesService.deleteHighVoltInfoById(informationById, forChooseCableById);
    }

}
