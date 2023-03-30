package com.myproject.controller.dto.lightinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LightInformationChooseLuminariesRequestDTO {
    @JsonProperty("lightingId")
    private Long lightingId;
    @JsonProperty("heightProductionHall")
    private double heightProductionHall;
    @JsonProperty("widthProductionHall")
    private double widthProductionHall;
    @JsonProperty("lengthProductionHall")
    private double lengthProductionHall;

    public Long getLightingId() {
        return lightingId;
    }

    public double getHeightProductionHall() {
        return heightProductionHall;
    }

    public double getWidthProductionHall() {
        return widthProductionHall;
    }

    public double getLengthProductionHall() {
        return lengthProductionHall;
    }
}
