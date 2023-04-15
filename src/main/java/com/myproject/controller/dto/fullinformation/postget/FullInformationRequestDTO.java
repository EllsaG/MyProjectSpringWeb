package com.myproject.controller.dto.fullinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.entity.FullStartInformId;
import lombok.Getter;

import java.util.List;
@Getter
public class FullInformationRequestDTO {
    @JsonProperty("id")
    private long id;
    @JsonProperty("nameOfBusbar")
    private String nameOfBusbar;
    @JsonProperty("numbersAndAmountOfEquipments")
    private List <FullStartInformIdRequestDTO> fullStartInformId;

}
