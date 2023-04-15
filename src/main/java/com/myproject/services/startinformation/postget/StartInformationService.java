package com.myproject.services.startinformation.postget;

import com.myproject.controller.dto.startinformation.postget.StartInformationResponseDTO;
import com.myproject.entity.StartInformation;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.StartInformationRepository;
import com.myproject.utils.ForStartTableLoadCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StartInformationService {

    private final StartInformationRepository startInformationRepository;

    @Autowired
    public StartInformationService(StartInformationRepository startInformationRepository) {
        this.startInformationRepository = startInformationRepository;
    }

    public StartInformationResponseDTO save(long startInformId, String name, double power, int amount,
                                            double ki, double cosf, double tgf) {
        ForStartTableLoadCalculation forStartTableLoadCalculation = new ForStartTableLoadCalculation();
        StartInformation startInformation = forStartTableLoadCalculation
                .createIfDontExist(startInformationRepository, startInformId, name, power, amount, ki, cosf, tgf);// method checked  by id and name-power mapping
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
        startInformationRepository.delete(startInformation);
    }


}
