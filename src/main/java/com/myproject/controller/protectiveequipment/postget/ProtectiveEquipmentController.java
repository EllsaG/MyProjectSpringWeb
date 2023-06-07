package com.myproject.controller.protectiveequipment.postget;

import com.myproject.controller.dto.protectiveequipment.postget.ProtectiveEquipmentRequestDTO;
import com.myproject.controller.dto.protectiveequipment.postget.ProtectiveEquipmentResponseDTO;
import com.myproject.services.protectiveequipment.postget.ProtectiveEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectiveEquipmentController {

    private final ProtectiveEquipmentService protectiveEquipmentService;

    @Autowired
    public ProtectiveEquipmentController(ProtectiveEquipmentService protectiveEquipmentService) {
        this.protectiveEquipmentService = protectiveEquipmentService;
    }


    @GetMapping("/protectiveequipment/all")
    public ProtectiveEquipmentResponseDTO getAll() {
        ProtectiveEquipmentResponseDTO protectiveEquipmentResponseDTO = new ProtectiveEquipmentResponseDTO();
        protectiveEquipmentResponseDTO.setProtectiveEquipmentList(protectiveEquipmentService.getAllProtectiveEquipment());
        protectiveEquipmentResponseDTO.setProtectiveEquipmentSelectionList(protectiveEquipmentService.getAllForChooseProtectiveEquipment());

        return protectiveEquipmentResponseDTO;

    }

    @PostMapping("/protectiveequipment/create")
    public ProtectiveEquipmentResponseDTO create(@RequestBody ProtectiveEquipmentRequestDTO protectiveEquipmentRequestDTO) {
        return protectiveEquipmentService.save(protectiveEquipmentRequestDTO.getId(),protectiveEquipmentRequestDTO.getNominalCurrentOfThermalRelease(),
                protectiveEquipmentRequestDTO.getNominalCurrentOfElectromagneticRelease(), protectiveEquipmentRequestDTO.getNominalCurrentOfCircuitBreaker(),
                protectiveEquipmentRequestDTO.getTypeOfCircuitBreaker(),protectiveEquipmentRequestDTO.getCableType());
    }





}
