package com.myproject.controller.dto.fullinformation.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.controller.dto.fullinformation.postget.FullStartInformIdRequestDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
public class FullInformationUpdateRequestDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("nameOfBusbar")
    private String nameOfBusbar;
    @JsonProperty("numbersAndAmountOfEquipments")
    private List <FullStartInformIdRequestDTO> fullStartInformId;

}
