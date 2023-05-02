package com.myproject.controller.dto.highvoltcable.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.entity.InductiveImpedanceAreas;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter
public class ChooseHighVoltCablesRequestDTO {
    @JsonProperty("id")
    private long id;
    @JsonProperty("cableType")
    private String cableType;
}
