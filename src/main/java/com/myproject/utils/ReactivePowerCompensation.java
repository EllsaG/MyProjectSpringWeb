package com.myproject.utils;

import com.myproject.entity.CompensationDevice;
import com.myproject.entity.CompensationDeviceSelection;
import com.myproject.entity.FullInformation;
import com.myproject.exceptions.IncorrectNumberValueException;
import com.myproject.repositories.ForChooseCompensationDeviceRepository;
import com.myproject.repositories.FullInformationRepository;

public class ReactivePowerCompensation {
    private static final double coefTakingIncreasingCosf = 0.9;

    public CompensationDeviceSelection powerOfCompensatingDevice(long id, double avgDailyActivePower, double tgfBeforeCompensation) {
        double minTgfRecommendedAfterCompensation = 0.33;
        double maxTgfRecommendedAfterCompensation = 0.4;

        double maxPowerOfCompensatingDevice = Math.round(avgDailyActivePower * coefTakingIncreasingCosf
                * (tgfBeforeCompensation - minTgfRecommendedAfterCompensation) * 100.0) / 100.0;
        double  minPowerOfCompensatingDevice= Math.round(avgDailyActivePower * coefTakingIncreasingCosf
                * (tgfBeforeCompensation - maxTgfRecommendedAfterCompensation) * 100.0) / 100.0;

        return new CompensationDeviceSelection(id, minPowerOfCompensatingDevice, maxPowerOfCompensatingDevice);


    }

    public CompensationDevice createNewCompensatingDevice(long id, String nameOfCompensationDevice, double powerOfCompensatingDevice,
                                                        FullInformationRepository fullInformationRepository, ForChooseCompensationDeviceRepository forChooseCompensationDeviceRepository) {
        FullInformation fullInformation = fullInformationRepository.findById(id).get();

        double avgDailyActivePower = fullInformation.getAvgDailyActivePower();
        double tgfBeforeCompensation = fullInformation.getTgF();

        double tgfActualValueCheck = tgfBeforeCompensation - powerOfCompensatingDevice
                / (coefTakingIncreasingCosf * avgDailyActivePower);

        if (tgfActualValueCheck >=0.33 && tgfActualValueCheck <= 0.4){
            return new CompensationDevice(id, nameOfCompensationDevice, powerOfCompensatingDevice);
        }else {
            CompensationDeviceSelection compensationDeviceSelection = forChooseCompensationDeviceRepository.findById(id).get();
            double minPowerOfCompensatingDevice = compensationDeviceSelection.getMinPowerOfCompensatingDevice();
            double maxPowerOfCompensatingDevice = compensationDeviceSelection.getMaxPowerOfCompensatingDevice();
            throw new IncorrectNumberValueException("Incorrect power value of the compensating device, as it should be between "
                    + minPowerOfCompensatingDevice + " and " + maxPowerOfCompensatingDevice);
        }




    }


}
