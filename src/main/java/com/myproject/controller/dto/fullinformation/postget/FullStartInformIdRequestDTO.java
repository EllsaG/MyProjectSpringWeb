package com.myproject.controller.dto.fullinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class FullStartInformIdRequestDTO {

    @JsonProperty("numberOfBusbar")
    private long numberOfBusbar;
    @JsonProperty("numbersOfEquipment")
    private long numberOfEquipment;
    @JsonProperty("amountOfEquipments")
    private int amountOfEquipment;


}
