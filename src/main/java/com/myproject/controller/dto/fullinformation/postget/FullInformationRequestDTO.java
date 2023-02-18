package com.myproject.controller.dto.fullinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

public class FullInformationRequestDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nameOfBusbar")
    private String nameOfBusbar;

    @JsonProperty("numbersAndAmountOfEquipments")
    private List <NumbersAndAmountOfEquipmentsRequestDTO> numbersAndAmountOfEquipments;

    public Long getId() {
        return id;
    }

    public String getNameOfBusbar() {
        return nameOfBusbar;
    }

    public List <NumbersAndAmountOfEquipmentsRequestDTO> getNumbersAndAmountOfEquipments() {
        return numbersAndAmountOfEquipments;
    }
}
