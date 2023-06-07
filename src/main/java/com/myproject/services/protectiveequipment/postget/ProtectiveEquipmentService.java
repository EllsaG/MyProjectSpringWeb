package com.myproject.services.protectiveequipment.postget;

import com.myproject.controller.dto.protectiveequipment.postget.ProtectiveEquipmentResponseDTO;
import com.myproject.entity.ProtectiveEquipmentSelection;
import com.myproject.entity.ProtectiveEquipment;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.ForChooseProtectiveEquipmentRepository;
import com.myproject.repositories.ProtectiveEquipmentRepository;
import com.myproject.repositories.StartInformationRepository;
import com.myproject.utils.ForProtectiveEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProtectiveEquipmentService {
    private final ForChooseProtectiveEquipmentRepository forChooseProtectiveEquipmentRepository;
    private final StartInformationRepository startInformationRepository;
    private final ProtectiveEquipmentRepository protectiveEquipmentRepository;


    @Autowired
    public ProtectiveEquipmentService(ForChooseProtectiveEquipmentRepository forChooseProtectiveEquipmentRepository,
                                      StartInformationRepository startInformationRepository,
                                      ProtectiveEquipmentRepository protectiveEquipmentRepository) {
        this.forChooseProtectiveEquipmentRepository = forChooseProtectiveEquipmentRepository;
        this.startInformationRepository = startInformationRepository;
        this.protectiveEquipmentRepository = protectiveEquipmentRepository;
    }


    public ProtectiveEquipmentResponseDTO save(long id, double nominalCurrentOfThermalRelease, double nominalCurrentOfElectromagneticRelease,
                                               double nominalCurrentOfCircuitBreaker, String typeOfCircuitBreaker, String cableType) {

        ForProtectiveEquipment forProtectiveEquipment = new ForProtectiveEquipment();
        ProtectiveEquipment newProtectiveEquipment = forProtectiveEquipment.createNew(id, nominalCurrentOfThermalRelease,
                nominalCurrentOfElectromagneticRelease, nominalCurrentOfCircuitBreaker, typeOfCircuitBreaker, cableType,
                startInformationRepository, forChooseProtectiveEquipmentRepository);

        protectiveEquipmentRepository.save(newProtectiveEquipment);

        return new ProtectiveEquipmentResponseDTO(getAllProtectiveEquipment(), getAllForChooseProtectiveEquipment());

    }

    public ProtectiveEquipmentResponseDTO update(long id, double nominalCurrentOfThermalRelease, double nominalCurrentOfElectromagneticRelease,
                                                 double nominalCurrentOfCircuitBreaker, String typeOfCircuitBreaker, String cableType) {
        return save(id, nominalCurrentOfThermalRelease, nominalCurrentOfElectromagneticRelease,
                nominalCurrentOfCircuitBreaker, typeOfCircuitBreaker, cableType);
    }


    public void delete(ProtectiveEquipment protectiveEquipment) {
        protectiveEquipmentRepository.delete(protectiveEquipment);
    }

    public ProtectiveEquipment getByIdProtectiveEquipment(long id) {
        return protectiveEquipmentRepository.findById(id)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about the protected equipment. Check the availability of this equipment."));
    }

    public List<ProtectiveEquipment> getAllProtectiveEquipment() {
        return protectiveEquipmentRepository.findAll();
    }

    public List<ProtectiveEquipmentSelection> getAllForChooseProtectiveEquipment() {
        return forChooseProtectiveEquipmentRepository.findAll();
    }

}
