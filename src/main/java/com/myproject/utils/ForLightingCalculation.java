package com.myproject.utils;

import com.myproject.controller.dto.lightinformation.postget.LightInformationChooseLuminariesResponseDTO;
import com.myproject.entity.LuminaireSelection;
import com.myproject.entity.LightInformation;
import com.myproject.exceptions.InformationAlreadyExistsException;
import com.myproject.repositories.ForChooseLuminaireRepository;
import com.myproject.repositories.LightInformationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ForLightingCalculation {


    public LuminaireSelection lightingCalculation(long lightingId, double productionHallHeight,
                                                  double productionHallWidth, double productionHallLength,
                                                  ForChooseLuminaireRepository forChooseLuminaireRepository) {

        Optional<LuminaireSelection> byId = forChooseLuminaireRepository.findById(lightingId);
        if (byId.isPresent()) {
            throw new InformationAlreadyExistsException("Information about production hall with id № " + lightingId + " is already exists");
        }

        List<LuminaireSelection> all = forChooseLuminaireRepository.findAll();

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getProductionHallHeight() == productionHallHeight &&
                    all.get(i).getProductionHallWidth() == productionHallWidth &&
                    all.get(i).getProductionHallLength() == productionHallLength) {
                throw new InformationAlreadyExistsException("Information about production hall with height: " + productionHallHeight +
                        ", width: " + productionHallWidth +
                        " and length: " + productionHallLength +
                        " is already exists");
            }
        }

        final double heightOfWorkSurface = 0.8;

        final int ratedLight = 300;
        final double safetyFactor = 1.5;
        final double coefOfLightingIrregularity = 1.15;
        final double coefEfficiencyOfLuminaire = 0.8;

        double heightLampUnderCeiling = 1.2; // maybe between 0 and 2.5

        double coef = 1.0; // coefficient of the relative ratio of suspension height and distance between luminaires (maybe between 0.8 and 1.5)

        double heightOverWorkSurface = productionHallHeight - heightOfWorkSurface - heightLampUnderCeiling;

        double distanceBetweenRowsOfLamps = heightOverWorkSurface * coef;

        double distanceBetweenWallAndFirstRowOfLamps = (double) Math.round(0.25 * distanceBetweenRowsOfLamps * 10) / 10; // coef "0.25" maybe between 0.25 and 0.3

        int amountLuminairesPerLength = (int) Math.floor((productionHallLength -
                2 * distanceBetweenWallAndFirstRowOfLamps) / distanceBetweenRowsOfLamps) + 1;

        int amountLuminairesPerWidth = (int) Math.floor((productionHallWidth -
                2 * distanceBetweenWallAndFirstRowOfLamps) / distanceBetweenRowsOfLamps) + 1;

        double lightFlux = Math.ceil((ratedLight * productionHallLength * productionHallWidth * safetyFactor * coefOfLightingIrregularity) /
                (1 * amountLuminairesPerLength * amountLuminairesPerWidth * coefEfficiencyOfLuminaire));

        return new LuminaireSelection(lightingId, distanceBetweenRowsOfLamps, distanceBetweenWallAndFirstRowOfLamps,
                amountLuminairesPerLength, amountLuminairesPerWidth, lightFlux, productionHallHeight, productionHallWidth, productionHallLength);

    }

    public LightInformationChooseLuminariesResponseDTO forResponseChooseLuminaries(ForChooseLuminaireRepository forChooseLuminaireRepository) {

        List<LuminaireSelection> all = forChooseLuminaireRepository.findAll();
        LightInformationChooseLuminariesResponseDTO lightInformationChooseLuminariesResponseDTO =
                new LightInformationChooseLuminariesResponseDTO();// min and max light flux at 1, 2, 3 and 4 lamps in the Luminaire
        List<LightFluxAtAmountOfLamps> lightFluxAtAmountOfLamps = new ArrayList<>();

        for (LuminaireSelection f: all) {
            double lightFlux = f.getLightFlux();
            double minLightFluxForChooseLuminaire = Math.ceil(lightFlux * 1.4);
            double maxLightFluxForChooseLuminaire = Math.ceil(lightFlux * 1.6);

            for (int amountOfLamps = 1; amountOfLamps < 5; amountOfLamps++) {
                lightFluxAtAmountOfLamps.add(new LightFluxAtAmountOfLamps(f.getId(),
                        amountOfLamps,
                        Math.round(minLightFluxForChooseLuminaire/amountOfLamps*10)/10.0,
                        Math.round(maxLightFluxForChooseLuminaire/amountOfLamps*10)/10.0));
            }
            lightInformationChooseLuminariesResponseDTO.setLightFluxAtAmountOfLampsList(lightFluxAtAmountOfLamps);
        }

        return lightInformationChooseLuminariesResponseDTO;
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

        List<LuminaireSelection> all = forChooseLuminaireRepository.findAll();

        double distanceBetweenRowsOfLamps = all.get(0).getDistanceBetweenLampRows();
        double distanceBetweenWallAndFirstRowOfLamps = all.get(0).getDistanceBetweenWallAndFirstLampRow();
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
