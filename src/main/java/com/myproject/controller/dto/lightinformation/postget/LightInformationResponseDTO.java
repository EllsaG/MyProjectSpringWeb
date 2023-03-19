package com.myproject.controller.dto.lightinformation.postget;

import java.util.HashMap;

public class LightInformationResponseDTO {

    HashMap<Integer, HashMap<Double,Double>> lightFluxAtAmountOfLamps;

    public LightInformationResponseDTO(HashMap<Integer, HashMap<Double, Double>> lightFluxAtAmountOfLamps) {
        this.lightFluxAtAmountOfLamps = lightFluxAtAmountOfLamps;
    }

    public HashMap<Integer, HashMap<Double, Double>> getLightFluxAtAmountOfLamps() {
        return lightFluxAtAmountOfLamps;
    }

    public void setLightFluxAtAmountOfLamps(HashMap<Integer, HashMap<Double, Double>> lightFluxAtAmountOfLamps) {
        this.lightFluxAtAmountOfLamps = lightFluxAtAmountOfLamps;
    }
}
