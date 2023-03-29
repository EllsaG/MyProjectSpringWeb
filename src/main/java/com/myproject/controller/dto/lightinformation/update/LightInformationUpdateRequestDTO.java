package com.myproject.controller.dto.lightinformation.update;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LightInformationUpdateRequestDTO {
    @JsonProperty("lightingId")
    private long lightingId;
    @JsonProperty("modelOfLuminaire")
    private String modelOfLuminaire;
    @JsonProperty("modelOfLamp")
    private String modelOfLamp;
    @JsonProperty("amountOfLampsInOneLuminaire")
    private int amountOfLampsInOneLuminaire;
    @JsonProperty("lightFluxOneLamp")
    private double lightFluxOneLamp;
    @JsonProperty("activePowerOneLamp")
    private double activePowerOneLamp;

    public long getLightingId() {
        return lightingId;
    }

    public String getModelOfLuminaire() {
        return modelOfLuminaire;
    }

    public String getModelOfLamp() {
        return modelOfLamp;
    }

    public int getAmountOfLampsInOneLuminaire() {
        return amountOfLampsInOneLuminaire;
    }

    public double getLightFluxOneLamp() {
        return lightFluxOneLamp;
    }

    public double getActivePowerOneLamp() {
        return activePowerOneLamp;
    }
}
