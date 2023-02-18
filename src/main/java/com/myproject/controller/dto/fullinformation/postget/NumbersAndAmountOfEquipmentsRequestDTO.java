package com.myproject.controller.dto.fullinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;


public class NumbersAndAmountOfEquipmentsRequestDTO {

    @JsonProperty("numbersOfEquipment")
    private Integer numbersOfEquipment;
    @JsonProperty("amountOfEquipments")
    private Integer amountOfEquipments;


    public Integer getAmountOfEquipments() {
        return amountOfEquipments;
    }

    public void setAmountOfEquipments(Integer amountOfEquipments) {
        this.amountOfEquipments = amountOfEquipments;
    }

    public Integer getNumbersOfEquipment() {
        return numbersOfEquipment;
    }

    public void setNumbersOfEquipment(Integer numbersOfEquipment) {
        this.numbersOfEquipment = numbersOfEquipment;
    }
}
