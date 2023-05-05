package com.myproject.controller.dto.highvoltcable.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ChooseHighVoltCablesUpdateRequestDTO {
    @JsonProperty("id")
    private long id;
    @JsonProperty("cableType")
    private String cableType;
}
