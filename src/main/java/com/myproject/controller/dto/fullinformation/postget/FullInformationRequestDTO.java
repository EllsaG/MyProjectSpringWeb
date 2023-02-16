package com.myproject.controller.dto.fullinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.entity.StartInformation;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class FullInformationRequestDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nameOfBusbar")
    private String nameOfBusbar;

    @JsonProperty("numbersAndAmountOfEquipments")
    private HashMap<Integer, Integer> numbersAndAmountOfEquipments;

    public Long getId() {
        return id;
    }

    public String getNameOfBusbar() {
        return nameOfBusbar;
    }

    public HashMap<Integer, Integer> getNumbersAndAmountOfEquipments() {
        return numbersAndAmountOfEquipments;
    }
}
