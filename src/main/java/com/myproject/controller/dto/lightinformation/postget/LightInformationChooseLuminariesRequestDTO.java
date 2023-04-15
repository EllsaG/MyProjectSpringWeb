package com.myproject.controller.dto.lightinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class LightInformationChooseLuminariesRequestDTO {
    @JsonProperty("lightingId")
    private long lightingId;
    @JsonProperty("heightProductionHall")
    private double heightProductionHall;
    @JsonProperty("widthProductionHall")
    private double widthProductionHall;
    @JsonProperty("lengthProductionHall")
    private double lengthProductionHall;
}
