package com.myproject.utils;

import com.myproject.entity.FullInformation;
import com.myproject.entity.PowerTransformers;
import com.myproject.repositories.FullInformationRepository;

public class ChoosingOfTransformers {


    public double ratedPowerForChoosingOfTransformer(double maxFullPower) {
        double lossesOfActivePower = 0.2 * maxFullPower;
        double lossesOfReactivePower = 0.1 * maxFullPower;
        double lossesOfFullPower = Math.sqrt(Math.pow(lossesOfActivePower, 2) + Math.pow(lossesOfReactivePower, 2));

        return maxFullPower + lossesOfFullPower;
    }

    public PowerTransformers createNewTransformer(long id, String modelOfTransformer, double fullPowerOfTransformer,
                                                  double shortCircuitVoltage, double idleLossesOfTransformer,
                                                  double highSideVoltage, double lowSideVoltage, double shortCircuitLosses, double idleCurrent,
                                                  FullInformationRepository fullInformationRepository, double powerOfChosenTransformer) {

        FullInformation fullInformation = fullInformationRepository.findById(id).get();
        double maxFullPower = fullInformation.getMaxFullPower();
        double coefOfTransformerLoad = maxFullPower / powerOfChosenTransformer;

        return new PowerTransformers(id, modelOfTransformer, fullPowerOfTransformer, coefOfTransformerLoad,
                shortCircuitVoltage, idleLossesOfTransformer, highSideVoltage, lowSideVoltage,
                shortCircuitLosses, idleCurrent);
    }


}
