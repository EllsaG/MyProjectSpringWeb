package com.myproject.controller.dto.fullinformation.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.controller.dto.fullinformation.postget.FullStartInformIdRequestDTO;

import java.util.List;

public class FullInformationUpdateRequestDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nameOfBusbar")
    private String nameOfBusbar;

    @JsonProperty("numbersAndAmountOfEquipments")
    private List <FullStartInformIdRequestDTO> fullStartInformId;

    public Long getId() {
        return id;
    }

    public String getNameOfBusbar() {
        return nameOfBusbar;
    }

    public List <FullStartInformIdRequestDTO> getFullStartInformIdRequestDTO() {
        return fullStartInformId;
    }
}
