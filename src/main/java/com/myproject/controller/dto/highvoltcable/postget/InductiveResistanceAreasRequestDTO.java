package com.myproject.controller.dto.highvoltcable.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class InductiveResistanceAreasRequestDTO {
    @JsonProperty("inductiveResistance")
    private double inductiveResistance;
}