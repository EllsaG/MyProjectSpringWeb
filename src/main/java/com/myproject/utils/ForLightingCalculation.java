package com.myproject.utils;

import com.myproject.entity.ForChooseLuminaire;
import com.myproject.entity.LightInformation;
import com.myproject.exceptions.InformationAlreadyExistsException;
import com.myproject.repositories.ForChooseLuminaireRepository;
import com.myproject.repositories.LightInformationRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ForLightingCalculation {


    public ForChooseLuminaire lightingCalculation(long lightingId,
            double heightProductionHall, double widthProductionHall,
            double lengthProductionHall) {

        final double heightOfWorkSurface = 0.8;

        final int ratedLight = 300;
        final double safetyFactor = 1.5;
        final double coefOfLightingIrregularity = 1.15;
        final double coefEfficiencyOfLuminaire = 0.8;

        double heightLampUnderCeiling = 1.2; // maybe between 0 and 2.5

        double coef = 1.0; // coefficient of the relative ratio of suspension height and distance between luminaires (maybe between 0.8 and 1.5)

        double heightOverWorkSurface = heightProductionHall - heightOfWorkSurface - heightLampUnderCeiling;

        double distanceBetweenRowsOfLamps = heightOverWorkSurface * coef;

        double distanceBetweenWallAndFirstRowOfLamps = (double) Math.round(0.25 * distanceBetweenRowsOfLamps * 10) / 10; // coef "0.25" maybe between 0.25 and 0.3

        int amountLuminairesPerLength = (int) Math.floor((lengthProductionHall -
                2 * distanceBetweenWallAndFirstRowOfLamps) / distanceBetweenRowsOfLamps) + 1;

        int amountLuminairesPerWidth = (int) Math.floor((widthProductionHall -
                2 * distanceBetweenWallAndFirstRowOfLamps) / distanceBetweenRowsOfLamps) + 1;

        double lightFlux = Math.ceil((ratedLight * lengthProductionHall * widthProductionHall * safetyFactor * coefOfLightingIrregularity) /
                (1 * amountLuminairesPerLength * amountLuminairesPerWidth * coefEfficiencyOfLuminaire));

        return new ForChooseLuminaire(lightingId, distanceBetweenRowsOfLamps, distanceBetweenWallAndFirstRowOfLamps,
                amountLuminairesPerLength, amountLuminairesPerWidth, lightFlux);

    }

    public HashMap<Integer, HashMap<Double, Double>> forResponseLightingCalculation(ForChooseLuminaireRepository forChooseLuminaireRepository) {

        List<ForChooseLuminaire> all = forChooseLuminaireRepository.findAll();
        double lightFlux = all.get(0).getLightFlux();

        double minLightFluxForChooseLuminaire = Math.ceil(lightFlux * 1.4);
        double maxLightFluxForChooseLuminaire = Math.ceil(lightFlux * 1.6);

        HashMap<Integer, HashMap<Double, Double>> lightFluxAtAmountOfLamps = new HashMap<>();// min and max LightFluxForChooseLuminaire at 1, 2, 3 and 4 lamps in the Luminaire

        HashMap<Double, Double> atOneLamp = new HashMap<>();
        atOneLamp.put(minLightFluxForChooseLuminaire, maxLightFluxForChooseLuminaire);
        HashMap<Double, Double> atTwoLamp = new HashMap<>();
        atTwoLamp.put(Math.ceil(minLightFluxForChooseLuminaire / 2), Math.ceil(maxLightFluxForChooseLuminaire / 2));
        HashMap<Double, Double> atThreeLamp = new HashMap<>();
        atThreeLamp.put(Math.ceil(minLightFluxForChooseLuminaire / 3), Math.ceil(maxLightFluxForChooseLuminaire / 3));
        HashMap<Double, Double> atFourLamp = new HashMap<>();
        atFourLamp.put(Math.ceil(minLightFluxForChooseLuminaire / 4), Math.ceil(maxLightFluxForChooseLuminaire / 4));

        lightFluxAtAmountOfLamps.put(1, atOneLamp);
        lightFluxAtAmountOfLamps.put(2, atTwoLamp);
        lightFluxAtAmountOfLamps.put(3, atThreeLamp);
        lightFluxAtAmountOfLamps.put(4, atFourLamp);

        return lightFluxAtAmountOfLamps;
    }


    public LightInformation electricCalculation(ForChooseLuminaireRepository forChooseLuminaireRepository, LightInformationRepository lightInformationRepository,
                                                long lightingId, String modelOfLuminaire,
                                                String modelOfLamp, double lightFluxOneLamp, int amountOfLampsInOneLuminaire, double activePowerOneLamp) {

        Optional<LightInformation> byId = lightInformationRepository.findById(lightingId);

        if (byId.isPresent()) {
            throw new InformationAlreadyExistsException("Information about lighting with id № " + lightingId + " is already exists");
        }


        final double coefDemand = 0.9;// check http://electricalschool.info/main/lighting/296-kak-opredelit-raschetnuju-moshhnost.html
        final double coefPRA = 1.1;// check http://electricalschool.info/main/lighting/296-kak-opredelit-raschetnuju-moshhnost.html
        final double coefP = 1.4;// check http://electricalschool.info/main/lighting/296-kak-opredelit-raschetnuju-moshhnost.html
        final double cosf = 0.95;
        final double tgf = 0.33;

        List<ForChooseLuminaire> all = forChooseLuminaireRepository.findAll();

        double distanceBetweenRowsOfLamps = all.get(0).getDistanceBetweenRowsOfLamps();
        double distanceBetweenWallAndFirstRowOfLamps = all.get(0).getDistanceBetweenWallAndFirstRowOfLamps();
        int amountLuminairesPerLength = all.get(0).getAmountLuminairesPerLength();
        int amountLuminairesPerWidth = all.get(0).getAmountLuminairesPerWidth();


        int amountOfLuminaires = amountLuminairesPerLength * amountLuminairesPerWidth;

        double activePower = Math.ceil(coefDemand * (amountOfLampsInOneLuminaire * amountOfLuminaires) * activePowerOneLamp * coefPRA * 100)/ 100.0;

        double reactivePower = Math.ceil((activePower * tgf)* 100) / 100.0;

        double fullPower = Math.ceil(Math.sqrt(Math.pow(activePower, 2) +
                Math.pow(reactivePower, 2))* 100) / 100.0;

        double electricCurrent = Math.ceil(((coefP * fullPower) / (Math.sqrt(3) * 380)) * 100000) / 100.0; // max electric current of this busbar

        double electricCurrentOfOneRowOfLuminaire = Math.round(((coefP * electricCurrent) /
                (Math.sqrt(3) * 0.38 * amountLuminairesPerLength)) *100) / 100.0 ;

        return new LightInformation(lightingId, modelOfLuminaire, modelOfLamp, amountOfLuminaires, amountOfLampsInOneLuminaire,
                activePowerOneLamp, lightFluxOneLamp, distanceBetweenRowsOfLamps,
                distanceBetweenWallAndFirstRowOfLamps, amountLuminairesPerLength, amountLuminairesPerWidth,
                activePower, reactivePower, fullPower, electricCurrent, electricCurrentOfOneRowOfLuminaire, cosf, tgf);
    }


}
