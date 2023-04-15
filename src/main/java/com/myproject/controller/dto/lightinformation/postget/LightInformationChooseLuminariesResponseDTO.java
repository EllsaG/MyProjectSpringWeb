package com.myproject.controller.dto.lightinformation.postget;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Objects;
@Getter
@Setter
@EqualsAndHashCode
public class LightInformationChooseLuminariesResponseDTO {

    HashMap<Integer, HashMap<Double,Double>> lightFluxAtAmountOfLamps;
    public LightInformationChooseLuminariesResponseDTO(HashMap<Integer, HashMap<Double, Double>> lightFluxAtAmountOfLamps) {
        this.lightFluxAtAmountOfLamps = lightFluxAtAmountOfLamps;
    }


}
