package com.myproject.controller.dto.protectiveequipment.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class ProtectiveEquipmentUpdateRequestDTO {

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


}
