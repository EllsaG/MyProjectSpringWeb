package com.myproject.controller.dto.lightinformation.update;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LightInformationUpdateRequestDTO {
    @JsonProperty("lightInformId")
    private long lightInformId;
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

    public long getLightInformId() {
        return lightInformId;
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
