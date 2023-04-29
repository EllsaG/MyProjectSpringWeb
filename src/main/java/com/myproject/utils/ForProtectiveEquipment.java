package com.myproject.utils;

import com.myproject.entity.ForChooseProtectiveEquipment;
import com.myproject.entity.ProtectiveEquipment;
import com.myproject.entity.StartInformation;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.ForChooseProtectiveEquipmentRepository;
import com.myproject.repositories.StartInformationRepository;

public class ForProtectiveEquipment {


    public ForChooseProtectiveEquipment forChooseProtectiveEquipment(StartInformation startInformation) {
        final double efficiencyFactor = 0.87; // depends on type of equipment
        final double voltage = 0.38;
        final double coefIncreasingInrushCurrent = 5; // depends on type of equipment
        long startInformId = startInformation.getStartInformId();
        double nominalCurrentOfEquipment = Math.round(startInformation.getPower() /
                (Math.sqrt(3) * voltage * startInformation.getCosf() * efficiencyFactor) * 100) / 100.0;
        double startingCurrentOfEquipment = Math.round((nominalCurrentOfEquipment * coefIncreasingInrushCurrent * 100)/100.0);
        double calculatedCurrentOfThermalRelease = Math.round((1.15 * nominalCurrentOfEquipment * 100)/100.0);
        double calculatedCurrentOfElectromagneticRelease = Math.round((1.25 * startingCurrentOfEquipment * 100)/100.0);

        return new ForChooseProtectiveEquipment(startInformation.getStartInformId(),nominalCurrentOfEquipment,
                startingCurrentOfEquipment, calculatedCurrentOfThermalRelease, calculatedCurrentOfElectromagneticRelease);
    }


    public ProtectiveEquipment createNew(long id, double nominalCurrentOfThermalRelease, double nominalCurrentOfElectromagneticRelease,
                                         double nominalCurrentOfCircuitBreaker, String typeOfCircuitBreaker, StartInformationRepository startInformationRepository,
                                         ForChooseProtectiveEquipmentRepository forChooseProtectiveEquipmentRepository) {

        StartInformation startInformation = startInformationRepository.findById(id)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about the protected equipment. Check the availability of this equipment."));
        ForChooseProtectiveEquipment forChooseProtectiveEquipment = forChooseProtectiveEquipmentRepository.findById(id)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about the protected equipment. Check the availability of this equipment."));

        return new ProtectiveEquipment(id, typeOfCircuitBreaker, nominalCurrentOfThermalRelease, nominalCurrentOfElectromagneticRelease,
                nominalCurrentOfCircuitBreaker);
    }


}
