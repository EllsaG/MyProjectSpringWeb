package com.myproject.utils;

public class ReactivePowerCompensation {



    double avgDailyActivePower;
    double cosfBeforeCompensation;
    double tgfBeforeCompensation;
    double cosfRecommendedAfterCompensation = 1.04;
    double tgfRecommendedAfterCompensation = 0.33;

    final double coefTakingIncreasingCosf = 0.9;


    double powerOfCompensatingDevice = avgDailyActivePower * coefTakingIncreasingCosf
            *(tgfBeforeCompensation - tgfRecommendedAfterCompensation);

    double tgfActualValueCheck = tgfBeforeCompensation - powerOfCompensatingDevice
            /(coefTakingIncreasingCosf*avgDailyActivePower);

}
