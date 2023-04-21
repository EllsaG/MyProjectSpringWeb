package com.myproject.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LightFluxAtAmountOfLamps {
    long id;
    int amountOfLampsInOneLuminaire;
    double minLightFluxForChooseLuminaire;
    double maxLightFluxForChooseLuminaire;
}
