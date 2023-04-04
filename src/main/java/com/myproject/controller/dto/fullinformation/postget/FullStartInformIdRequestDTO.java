package com.myproject.controller.dto.fullinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;


public class FullStartInformIdRequestDTO {

    @JsonProperty("numberOfBusbar")
    private long numberOfBusbar;
    @JsonProperty("numbersOfEquipment")
    private long numberOfEquipment;
    @JsonProperty("amountOfEquipments")
    private int amountOfEquipment;

    public long getNumberOfBusbar() {
        return numberOfBusbar;
    }

    public int getAmountOfEquipment() {
        return amountOfEquipment;
    }

    public long getNumberOfEquipment() {
        return numberOfEquipment;
    }

}
