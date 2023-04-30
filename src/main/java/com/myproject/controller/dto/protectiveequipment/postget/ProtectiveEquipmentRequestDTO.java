package com.myproject.controller.dto.protectiveequipment.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class ProtectiveEquipmentRequestDTO {

    @JsonProperty("id")
    private long id;
    @JsonProperty("typeOfCircuitBreaker")
    private String typeOfCircuitBreaker;
    @JsonProperty("nominalCurrentOfThermalRelease")
    private double nominalCurrentOfThermalRelease;
    @JsonProperty("nominalCurrentOfElectromagneticRelease")
    private double nominalCurrentOfElectromagneticRelease;
    @JsonProperty("nominalCurrentOfCircuitBreaker")
    private double nominalCurrentOfCircuitBreaker;
    @JsonProperty("cableType")
    private String cableType;

}
