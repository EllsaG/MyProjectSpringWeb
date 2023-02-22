package com.myproject.service.startinformation.postget;

import com.myproject.entity.StartInformation;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.StartInformationRepository;
import com.myproject.utils.ForStartTableLoadCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StartInformationService {

    private final StartInformationRepository startInformationRepository;

    @Autowired
    public StartInformationService(StartInformationRepository startInformationRepository) {
        this.startInformationRepository = startInformationRepository;
    }

    public String save(Long startInformId, String name, double power, int amount,
                       double ki, double cosf, double tgf) {
        StartInformation startInformation = ForStartTableLoadCalculation
                .createIfDontExist(startInformationRepository, startInformId, name, power, amount, ki, cosf, tgf);// method checked only by id(because i don't know why it doesn't work)
        return "Information about new equipment № " +
                startInformationRepository.save(startInformation).getStartInformId() +
                "\n  name " + name +
                "\n  power " + power +
                "\n  amount " + amount +
                "\n  ki " + ki +
                "\n  cosf " + cosf +
                "\n  tgf " + tgf +
                "\nis saved";
    }

    public StartInformation getInformationById(Long startInformId) {
        return startInformationRepository.findById(startInformId)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about equipment with id № " + startInformId));
    }

    public StartInformation update(StartInformation startInformation) {
        return startInformationRepository.save(startInformation);
    }

    public void delete(StartInformation startInformation) {
        startInformationRepository.delete(startInformation);
    }


}
