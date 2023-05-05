package com.myproject.controller.highvoltcable.delete;

import com.myproject.controller.dto.highvoltcable.postget.ChooseHighVoltCablesResponseDTO;
import com.myproject.controller.dto.highvoltcable.postget.HighVoltCablesResponseDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesResponseDTO;
import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.services.highvoltcables.delete.HighVoltCableDeleteService;
import com.myproject.services.lightinformation.delete.LightInformationDeleteService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HighVoltCableDeleteController {

    private final HighVoltCableDeleteService highVoltCableDeleteService;

    public HighVoltCableDeleteController(HighVoltCableDeleteService highVoltCableDeleteService) {
        this.highVoltCableDeleteService = highVoltCableDeleteService;
    }
    @DeleteMapping("/highvoltcable/delete/{id}")
    public ChooseHighVoltCablesResponseDTO deleteCableById(@PathVariable long id){
        return highVoltCableDeleteService.deleteCableById(id);
    }
    @DeleteMapping("/highvoltcable/delete/forchoosehighvoltcales/{id}")
    public HighVoltCablesResponseDTO deleteLuminaireById(@PathVariable long id){
        return highVoltCableDeleteService.deleteHighVoltInfoById(id);
    }


}
