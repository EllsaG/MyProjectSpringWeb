package com.myproject.utils;

import com.myproject.controller.dto.lightinformation.postget.LightInformationCreateNewResponseDTO;
import com.myproject.entity.LightInformation;

import java.util.HashMap;

public class ForLightingCalculation {

    private static double distanceBetweenRowsOfLamps;
    private static double distanceBetweenWallAndFirstRowOfLamps;
    private static int amountLuminairesPerLength;
    private static int amountLuminairesPerWidth;
    private static double lightFlux;



    public static HashMap<Integer, HashMap<Double,Double>> lightingCalculation(Double heightProductionHall, Double widthProductionHall,
                                                                               Double lengthProductionHall) {

        final Double heightOfWorkSurface = 0.8;

        final Integer ratedLight = 300;
        final Double safetyFactor = 1.5;
        final Double coefOfLightingIrregularity = 1.15;
        final Double coefEfficiencyOfLuminaire = 0.8;

        Double heightLampUnderCeiling = 1.2; // maybe between 0 and 2.5

        Double coef = 1.0; // coefficient of the relative ratio of suspension height and distance between luminaires (maybe between 0.8 and 1.5)

        Double heightOverWorkSurface = heightProductionHall - heightOfWorkSurface - heightLampUnderCeiling;

        distanceBetweenRowsOfLamps = heightOverWorkSurface * coef;

         distanceBetweenWallAndFirstRowOfLamps = (double) Math.round(0.25 * distanceBetweenRowsOfLamps * 10) / 10; // coef "0.25" maybe between 0.25 and 0.3

         amountLuminairesPerLength = (int) Math.floor((lengthProductionHall -
                2 * distanceBetweenWallAndFirstRowOfLamps) / distanceBetweenRowsOfLamps)+1;

         amountLuminairesPerWidth = (int) Math.floor((widthProductionHall -
                2 * distanceBetweenWallAndFirstRowOfLamps) / distanceBetweenRowsOfLamps)+1;

         lightFlux = Math.ceil((ratedLight * lengthProductionHall * widthProductionHall * safetyFactor * coefOfLightingIrregularity) /
                (1 * amountLuminairesPerLength * amountLuminairesPerWidth * coefEfficiencyOfLuminaire));

        Double minLightFluxForChooseLuminaire = Math.ceil(lightFlux * 1.4);

        Double maxLightFluxForChooseLuminaire = Math.ceil(lightFlux * 1.6);

        HashMap<Integer, HashMap<Double,Double>> lightFluxAtAmountOfLamps = new HashMap<>();// min and max LightFluxForChooseLuminaire at 1, 2, 3 and 4 lamps in the Luminaire

        HashMap<Double,Double> atOneLamp = new HashMap<>();
        atOneLamp.put(minLightFluxForChooseLuminaire, maxLightFluxForChooseLuminaire);
        HashMap<Double,Double> atTwoLamp = new HashMap<>();
        atTwoLamp.put(Math.ceil(minLightFluxForChooseLuminaire/2), Math.ceil(maxLightFluxForChooseLuminaire/2));
        HashMap<Double,Double> atThreeLamp = new HashMap<>();
        atThreeLamp.put(Math.ceil(minLightFluxForChooseLuminaire/3), Math.ceil(maxLightFluxForChooseLuminaire/3));
        HashMap<Double,Double> atFourLamp = new HashMap<>();
        atFourLamp.put(Math.ceil(minLightFluxForChooseLuminaire/4), Math.ceil(maxLightFluxForChooseLuminaire/4));

        lightFluxAtAmountOfLamps.put(1,atOneLamp);
        lightFluxAtAmountOfLamps.put(2,atTwoLamp);
        lightFluxAtAmountOfLamps.put(3,atThreeLamp);
        lightFluxAtAmountOfLamps.put(4,atFourLamp);

        return lightFluxAtAmountOfLamps;
    }

    public static LightInformation electricCalculation(String modelOfLuminaire, String modelOfLamp, double lightFluxOneLamp,
                                                       int amountOfLampsInOneLuminaire, double activePowerOneLamp) {

        final double coefDemand = 0.9;// check http://electricalschool.info/main/lighting/296-kak-opredelit-raschetnuju-moshhnost.html
        final double coefPRA = 1.1;// check http://electricalschool.info/main/lighting/296-kak-opredelit-raschetnuju-moshhnost.html
        final double coefP = 1.4;// check http://electricalschool.info/main/lighting/296-kak-opredelit-raschetnuju-moshhnost.html
        final double cosf = 0.95;
        final double tgf = 0.33;

        int amountOfLuminaires = amountLuminairesPerLength * amountLuminairesPerWidth;

        double activePower = Math.round(coefDemand * (amountOfLampsInOneLuminaire * amountOfLuminaires ) * activePowerOneLamp * coefPRA);

        double reactivePower = Math.round(activePower * tgf);

        double fullPower = Math.round(Math.sqrt(Math.pow(activePower, 2) +
                Math.pow(reactivePower, 2)) * 100.0) / 100.0;

        double electricCurrent = Math.round(((coefP * fullPower) / (Math.sqrt(3) * 380)) * 100) / 100.0; // max electric current of this busbar

        double electricCurrentOfOneRowOfLuminaire = Math.round(((coefP * electricCurrent) /
                (Math.sqrt(3) * 0.38 * amountLuminairesPerLength)) * 100) / 100.0;

        return new LightInformation(modelOfLuminaire, modelOfLamp,amountOfLuminaires, amountOfLampsInOneLuminaire,
                activePowerOneLamp,lightFluxOneLamp, distanceBetweenRowsOfLamps,
                distanceBetweenWallAndFirstRowOfLamps, amountLuminairesPerLength, amountLuminairesPerWidth,
                activePower, reactivePower, fullPower, electricCurrent, electricCurrentOfOneRowOfLuminaire, cosf, tgf);
    }




}
