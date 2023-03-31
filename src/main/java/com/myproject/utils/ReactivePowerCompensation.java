package com.myproject.utils;

public class ReactivePowerCompensation {

//    Номинальное напряжение питающей сети U_ном  = 380/220 В;
//    Коэффициент, учитывающий повышение коэффициента мощности
//            = 0.9

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
