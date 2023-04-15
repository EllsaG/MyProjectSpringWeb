package com.myproject.controller.dto.powertransformers.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PowerTransformersUpdateRequestDTO {

    @JsonProperty("id")
    private long id;
    @JsonProperty("modelOfTransformer")
    private String modelOfTransformer;
    @JsonProperty("fullPowerOfTransformer")
    private double fullPowerOfTransformer;
    @JsonProperty("coefOfTransformerLoad")
    private double coefOfTransformerLoad;
    @JsonProperty("shortCircuitVoltage")
    private double shortCircuitVoltage;
    @JsonProperty("idleLossesOfTransformer")
    private double idleLossesOfTransformer;
    @JsonProperty("highSideVoltage")
    private double highSideVoltage;
    @JsonProperty("lowSideVoltage")
    private double lowSideVoltage;
    @JsonProperty("shortCircuitLosses")
    private double shortCircuitLosses;
    @JsonProperty("idleCurrent")
    private double idleCurrent;
}