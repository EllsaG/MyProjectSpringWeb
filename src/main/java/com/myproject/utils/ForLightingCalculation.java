package com.myproject.utils;

public class ForLightingCalculation {

    public static String lightingCalculation(Double widthProductionHall, Double lengthProductionHall,
                                             Double heightProductionHall, Integer amountLampsInLuminaire) {

        final Double heightOfWorkSurface = 0.8;

        final Integer ratedLight = 300;
        final Double safetyFactor = 1.5;
        final Double coefOfLightingIrregularity = 1.15;
        final Double coefEfficiencyOfLuminaire = 0.8;

        Double heightLampUnderCeiling = 1.2; // maybe between 0 and 2.5

        Double coef = 1.0; // coefficient of the relative ratio of suspension height and distance between luminaires (maybe between 0.8 and 1.5)

        Double heightOverWorkSurface = heightProductionHall - heightOfWorkSurface - heightLampUnderCeiling;

        Double distanceBetweenRowsOfLamps = heightOverWorkSurface * coef;

        Double distanceBetweenWallAndFirstRowOfLamps = (double) Math.round(0.25 * distanceBetweenRowsOfLamps * 10) / 10; // coef "0.25" maybe between 0.25 and 0.3

        Integer amountLuminairesPerLength = (int) Math.floor((lengthProductionHall -
                2 * distanceBetweenWallAndFirstRowOfLamps) / distanceBetweenRowsOfLamps);

        Integer amountLuminairesPerWidth = (int) Math.floor((widthProductionHall -
                2 * distanceBetweenWallAndFirstRowOfLamps) / distanceBetweenRowsOfLamps);

        Double lightFlux = (ratedLight * lengthProductionHall * widthProductionHall * safetyFactor * coefOfLightingIrregularity) /
                (amountLampsInLuminaire * amountLuminairesPerLength * amountLuminairesPerWidth * coefEfficiencyOfLuminaire);

        Double minLightFluxForChooseLuminaire = lightFlux * 1.4;

        Double maxLightFluxForChooseLuminaire = lightFlux * 1.6;

        return "Ok";
    }

    public static String electricCalculation(Integer amountOfLamps, Double activePowerOneLamp, Integer amountLuminairesPerWidth) {

        final Double coefDemand = 0.9;// check http://electricalschool.info/main/lighting/296-kak-opredelit-raschetnuju-moshhnost.html
        final Double coefPRA = 1.1;// check http://electricalschool.info/main/lighting/296-kak-opredelit-raschetnuju-moshhnost.html
        final Double coefP = 1.4;// check http://electricalschool.info/main/lighting/296-kak-opredelit-raschetnuju-moshhnost.html
        final Double cosf = 0.95;
        final Double tgf = 0.33;


        Double activePower = coefDemand * amountOfLamps * activePowerOneLamp * coefPRA;

        Double reactivePower = activePower * tgf;

        Double fullPower = Math.round(Math.sqrt(Math.pow(activePower, 2) +
                Math.pow(reactivePower, 2)) * 100.0) / 100.0;

        Double electricCurrent = Math.round(((coefP*fullPower * 1000) / (Math.sqrt(3) * 380)) * 100) / 100.0; // max electric current of this busbar

        Double electricCurrentOFOneRowOfLuminaire = Math.round(((coefP*electricCurrent) /
                (Math.sqrt(3) * 380 * amountLuminairesPerWidth)) * 100) / 100.0;
        return "Ok";
    }


}
