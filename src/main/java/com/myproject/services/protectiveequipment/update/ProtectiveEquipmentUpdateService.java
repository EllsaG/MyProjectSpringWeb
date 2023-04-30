package com.myproject.services.protectiveequipment.update;

import com.myproject.controller.dto.powertransformers.postget.PowerTransformersResponseDTO;
import com.myproject.controller.dto.protectiveequipment.postget.ProtectiveEquipmentResponseDTO;
import com.myproject.entity.PowerTransformers;
import com.myproject.entity.ProtectiveEquipment;
import com.myproject.services.protectiveequipment.postget.ProtectiveEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProtectiveEquipmentUpdateService {

    private final ProtectiveEquipmentService protectiveEquipmentService;

@Autowired
    public ProtectiveEquipmentUpdateService(ProtectiveEquipmentService protectiveEquipmentService) {
        this.protectiveEquipmentService = protectiveEquipmentService;
    }


    public ProtectiveEquipmentResponseDTO update(long id, double nominalCurrentOfThermalRelease, double nominalCurrentOfElectromagneticRelease,
                                                 double nominalCurrentOfCircuitBreaker, String typeOfCircuitBreaker,String cableType) {
        ProtectiveEquipment byIdProtectiveEquipment = protectiveEquipmentService.getByIdProtectiveEquipment(id);
        protectiveEquipmentService.delete(byIdProtectiveEquipment);
        return protectiveEquipmentService.update(id, nominalCurrentOfThermalRelease, nominalCurrentOfElectromagneticRelease
                ,nominalCurrentOfCircuitBreaker, typeOfCircuitBreaker, cableType);
    }



}
