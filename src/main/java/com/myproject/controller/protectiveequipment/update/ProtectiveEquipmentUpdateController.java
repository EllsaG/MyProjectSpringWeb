package com.myproject.controller.protectiveequipment.update;

import com.myproject.controller.dto.powertransformers.postget.PowerTransformersResponseDTO;
import com.myproject.controller.dto.powertransformers.update.PowerTransformersUpdateRequestDTO;
import com.myproject.controller.dto.protectiveequipment.postget.ProtectiveEquipmentResponseDTO;
import com.myproject.controller.dto.protectiveequipment.update.ProtectiveEquipmentUpdateRequestDTO;
import com.myproject.services.protectiveequipment.update.ProtectiveEquipmentUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectiveEquipmentUpdateController {

    private final ProtectiveEquipmentUpdateService protectiveEquipmentUpdateService;

    @Autowired
    public ProtectiveEquipmentUpdateController(ProtectiveEquipmentUpdateService protectiveEquipmentUpdateService) {
        this.protectiveEquipmentUpdateService = protectiveEquipmentUpdateService;
    }

    @PostMapping("/protectiveequipment/update")
    public ProtectiveEquipmentResponseDTO update(@RequestBody ProtectiveEquipmentUpdateRequestDTO protectiveEquipmentUpdateRequestDTO) {
        return protectiveEquipmentUpdateService.update(protectiveEquipmentUpdateRequestDTO.getId(), protectiveEquipmentUpdateRequestDTO.getNominalCurrentOfThermalRelease(),
                protectiveEquipmentUpdateRequestDTO.getNominalCurrentOfElectromagneticRelease(), protectiveEquipmentUpdateRequestDTO.getNominalCurrentOfCircuitBreaker(),
                protectiveEquipmentUpdateRequestDTO.getTypeOfCircuitBreaker());
    }
}
