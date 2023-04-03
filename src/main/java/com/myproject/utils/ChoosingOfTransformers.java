package com.myproject.utils;

public class ChoosingOfTransformers {


    double avgDailyActivePower;
    double avgDailyReactivePower;
    double maxFullPower;


    double lossesOfActivePower = 0.2 * maxFullPower;
    double lossesOfReactivePower = 0.1 * maxFullPower;
    double lossesOfFullPower = Math.sqrt(Math.pow(lossesOfActivePower, 2) + Math.pow(lossesOfReactivePower,2));

    double ratedPowerOfTransformer = maxFullPower + lossesOfFullPower;

    double powerOfChosenTransformer;

    double coefOfTransformerLoad = maxFullPower / powerOfChosenTransformer;



}
