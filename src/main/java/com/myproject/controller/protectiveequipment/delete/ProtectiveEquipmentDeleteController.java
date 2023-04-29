package com.myproject.controller.protectiveequipment.delete;

import com.myproject.controller.dto.powertransformers.postget.PowerTransformersResponseDTO;
import com.myproject.controller.dto.protectiveequipment.postget.ProtectiveEquipmentResponseDTO;
import com.myproject.services.protectiveequipment.delete.ProtectiveEquipmentDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectiveEquipmentDeleteController {
    private final ProtectiveEquipmentDeleteService protectiveEquipmentDeleteService;
@Autowired
    public ProtectiveEquipmentDeleteController(ProtectiveEquipmentDeleteService protectiveEquipmentDeleteService) {
        this.protectiveEquipmentDeleteService = protectiveEquipmentDeleteService;
    }

    @DeleteMapping("/protectiveequipment/delete/{idForDelete}")
    public ProtectiveEquipmentResponseDTO deleteInfo(@PathVariable long idForDelete){
        return protectiveEquipmentDeleteService.delete(idForDelete);
    }


}
