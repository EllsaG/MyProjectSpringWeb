package com.myproject.services.startinformation.postget;

import com.myproject.controller.dto.startinformation.postget.StartInformationResponseDTO;
import com.myproject.entity.ForChooseProtectiveEquipment;
import com.myproject.entity.StartInformation;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.ForChooseProtectiveEquipmentRepository;
import com.myproject.repositories.StartInformationRepository;
import com.myproject.utils.ForProtectiveEquipment;
import com.myproject.utils.ForStartTableLoadCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StartInformationService {

    private final StartInformationRepository startInformationRepository;
    private final ForChooseProtectiveEquipmentRepository forChooseProtectiveEquipmentRepository;
    @Autowired
    public StartInformationService(StartInformationRepository startInformationRepository, ForChooseProtectiveEquipmentRepository forChooseProtectiveEquipmentRepository) {
        this.startInformationRepository = startInformationRepository;
        this.forChooseProtectiveEquipmentRepository = forChooseProtectiveEquipmentRepository;
    }

    public StartInformationResponseDTO save(long startInformId, String name, double power, int amount,
                                            double ki, double cosf, double tgf) {
        ForStartTableLoadCalculation forStartTableLoadCalculation = new ForStartTableLoadCalculation();
        StartInformation startInformation = forStartTableLoadCalculation
                .createIfDontExist(startInformationRepository, startInformId, name, power, amount, ki, cosf, tgf);// method checked  by id and name-power mapping
        ForProtectiveEquipment forProtectiveEquipment = new ForProtectiveEquipment();
        ForChooseProtectiveEquipment forChooseProtectiveEquipment = forProtectiveEquipment.forChooseProtectiveEquipment(startInformation);

        forChooseProtectiveEquipmentRepository.save(forChooseProtectiveEquipment);
        startInformationRepository.save(startInformation);

        return new StartInformationResponseDTO(getAllStartInformation());
    }

    public StartInformation getInformationById(long startInformId) {
        return startInformationRepository.findById(startInformId)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about equipment with id № " + startInformId));
    }
    public List<StartInformation> getAllStartInformation() {
        return startInformationRepository.findAll();
    }

    public StartInformation update(StartInformation startInformation) {
        return startInformationRepository.save(startInformation);
    }

    public void delete(StartInformation startInformation) {
        long startInformId = startInformation.getStartInformId();
        startInformationRepository.delete(startInformation);

        if (forChooseProtectiveEquipmentRepository.existsById(startInformId)){
            forChooseProtectiveEquipmentRepository.deleteById(startInformId);
        }
    }


}
