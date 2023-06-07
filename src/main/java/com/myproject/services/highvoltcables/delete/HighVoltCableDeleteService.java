package com.myproject.services.highvoltcables.delete;

import com.myproject.controller.dto.highvoltcable.postget.ChooseHighVoltCablesResponseDTO;
import com.myproject.controller.dto.highvoltcable.postget.HighVoltCablesResponseDTO;
import com.myproject.entity.*;
import com.myproject.services.highvoltcables.postget.HighVoltCablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        HighVoltCableSelection forChooseCableById = highVoltCablesService.getForChooseCableById(id);
        return highVoltCablesService.deleteHighVoltInfoById(informationById, forChooseCableById);
    }

}
