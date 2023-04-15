package com.myproject.utils;

import com.myproject.entity.*;
import com.myproject.exceptions.IncorrectNumberValueException;
import com.myproject.repositories.ForChooseTransformersRepository;
import com.myproject.repositories.FullInformationRepository;

public class ChoosingOfTransformers {


    public ForChooseTransformers ratedPowerForChoosingOfTransformer(long id, double maxFullPower) {
        double lossesOfActivePower = 0.2 * maxFullPower;
        double lossesOfReactivePower = 0.1 * maxFullPower;
        double lossesOfFullPower = Math.sqrt(Math.pow(lossesOfActivePower, 2) + Math.pow(lossesOfReactivePower, 2));

        double ratedPowerForChoosingOfTransformer = Math.round(maxFullPower + lossesOfFullPower * 100.0)/100.0;
        return new ForChooseTransformers(id, ratedPowerForChoosingOfTransformer);
    }

    public PowerTransformers createNewTransformer(long id, String modelOfTransformer, double fullPowerOfTransformer,
                                                  double shortCircuitVoltage, double idleLossesOfTransformer,
                                                  double highSideVoltage, double lowSideVoltage, double shortCircuitLosses, double idleCurrent,
                                                   FullInformationRepository fullInformationRepository, ForChooseTransformersRepository forChooseTransformersRepository) {

        ForChooseTransformers forChooseTransformers = forChooseTransformersRepository.findById(id).get();
        FullInformation fullInformation = fullInformationRepository.findById(id).get();

        double maxFullPower = fullInformation.getMaxFullPower();
        double coefOfTransformerLoad =  Math.round(maxFullPower / fullPowerOfTransformer * 100.0)/100.0;

        if (fullPowerOfTransformer >= forChooseTransformers.getRatedPowerForChoosingOfTransformer()){
            return new PowerTransformers(id, modelOfTransformer, fullPowerOfTransformer, coefOfTransformerLoad,
                    shortCircuitVoltage, idleLossesOfTransformer, highSideVoltage, lowSideVoltage,
                    shortCircuitLosses, idleCurrent);
        }else {
            throw new IncorrectNumberValueException("Incorrect transformer power value, as it should be more than "
                    + forChooseTransformers.getRatedPowerForChoosingOfTransformer());
        }

    }


}
