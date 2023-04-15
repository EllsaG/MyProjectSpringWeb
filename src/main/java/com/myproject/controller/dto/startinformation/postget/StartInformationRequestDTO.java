package com.myproject.controller.dto.startinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class StartInformationRequestDTO {
    @JsonProperty("startInformId")
    private long startInformId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("power")
    private double power;
    @JsonProperty("amount")
    private int amount;
    @JsonProperty("ki")
    private double ki;
    @JsonProperty("cosf")
    private double cosf;
    @JsonProperty("tgf")
    private double tgf;

}
