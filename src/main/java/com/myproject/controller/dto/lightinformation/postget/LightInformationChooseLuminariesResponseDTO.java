package com.myproject.controller.dto.lightinformation.postget;

import java.util.HashMap;
import java.util.Objects;

public class LightInformationChooseLuminariesResponseDTO {

    HashMap<Integer, HashMap<Double,Double>> lightFluxAtAmountOfLamps;

    public LightInformationChooseLuminariesResponseDTO(HashMap<Integer, HashMap<Double, Double>> lightFluxAtAmountOfLamps) {
        this.lightFluxAtAmountOfLamps = lightFluxAtAmountOfLamps;
    }

    public HashMap<Integer, HashMap<Double, Double>> getLightFluxAtAmountOfLamps() {
        return lightFluxAtAmountOfLamps;
    }

    public void setLightFluxAtAmountOfLamps(HashMap<Integer, HashMap<Double, Double>> lightFluxAtAmountOfLamps) {
        this.lightFluxAtAmountOfLamps = lightFluxAtAmountOfLamps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightInformationChooseLuminariesResponseDTO that = (LightInformationChooseLuminariesResponseDTO) o;
        return Objects.equals(lightFluxAtAmountOfLamps, that.lightFluxAtAmountOfLamps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lightFluxAtAmountOfLamps);
    }
}
