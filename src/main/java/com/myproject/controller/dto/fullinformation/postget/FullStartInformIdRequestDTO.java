package com.myproject.controller.dto.fullinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;


public class FullStartInformIdRequestDTO {

    @JsonProperty("numberOfBusbar")
    private Long numberOfBusbar;
    @JsonProperty("numbersOfEquipment")
    private Long numberOfEquipment;
    @JsonProperty("amountOfEquipments")
    private Integer amountOfEquipment;

    public Long getNumberOfBusbar() {
        return numberOfBusbar;
    }

    public Integer getAmountOfEquipment() {
        return amountOfEquipment;
    }

    public Long getNumberOfEquipment() {
        return numberOfEquipment;
    }

}
