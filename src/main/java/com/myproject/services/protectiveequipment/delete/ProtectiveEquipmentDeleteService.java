package com.myproject.services.protectiveequipment.delete;

import com.myproject.controller.dto.protectiveequipment.postget.ProtectiveEquipmentResponseDTO;
import com.myproject.entity.ProtectiveEquipment;
import com.myproject.services.protectiveequipment.postget.ProtectiveEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProtectiveEquipmentDeleteService {

    private final ProtectiveEquipmentService protectiveEquipmentService;

    @Autowired
    public ProtectiveEquipmentDeleteService(ProtectiveEquipmentService protectiveEquipmentService) {
        this.protectiveEquipmentService = protectiveEquipmentService;
    }

    public ProtectiveEquipmentResponseDTO delete(long id) {
        ProtectiveEquipment byIdProtectiveEquipment = protectiveEquipmentService.getByIdProtectiveEquipment(id);
        protectiveEquipmentService.delete(byIdProtectiveEquipment);
        return new ProtectiveEquipmentResponseDTO(protectiveEquipmentService.getAllProtectiveEquipment(),
                protectiveEquipmentService.getAllForChooseProtectiveEquipment());
    }


}
