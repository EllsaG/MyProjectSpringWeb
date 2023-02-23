package com.myproject.utils;

import com.myproject.entity.StartInformation;
import com.myproject.exceptions.InformationAlreadyExistsException;
import com.myproject.repositories.StartInformationRepository;

import java.util.List;
import java.util.Optional;

public class ForStartTableLoadCalculation {

    public static StartInformation createIfDontExist(StartInformationRepository startInformationRepository, Long startInformId,
                                                     String name, double power, int amount, double ki, double cosf, double tgf) {

        Optional<StartInformation> byId = startInformationRepository.findById(startInformId);
        if (byId.isPresent()) {
            throw new InformationAlreadyExistsException("Information about equipment with id № " + startInformId + " is already exists");
        }

        List<StartInformation> all = startInformationRepository.findAll();

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getName().equals(name) && all.get(i).getPower() == power) {
                throw new InformationAlreadyExistsException("Information about equipment with name: " + name + " and power: " + power + " is already exists");
            }
        }

        double avgDailyActivePower = Math.round(power * ki * 100.0) / 100.0; // average daily active power of one equipment
        double avgDailyReactivePower = Math.round(avgDailyActivePower * tgf * 100.0) / 100.0; // average daily reactive power of one equipment


        return new StartInformation(startInformId, name, power, amount, ki, cosf, tgf, avgDailyActivePower, avgDailyReactivePower);

    }
}
