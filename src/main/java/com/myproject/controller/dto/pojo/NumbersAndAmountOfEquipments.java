package com.myproject.controller.dto.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NumbersAndAmountOfEquipments {


    private Integer numbersOfEquipment;
    private Integer amountOfEquipments;

    public NumbersAndAmountOfEquipments(Integer numbersOfEquipment, Integer amountOfEquipments) {
        this.numbersOfEquipment = numbersOfEquipment;
        this.amountOfEquipments = amountOfEquipments;
    }

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


    @Override
    public String toString() {
        return "NumbersAndAmountOfEquipments{" +
                "amountOfEquipments=" + amountOfEquipments +
                ", numbersOfEquipment=" + numbersOfEquipment +
                '}';
    }
}
