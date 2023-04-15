package com.myproject.controller.dto.startinformation.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
@Getter
public class UpdateRequestDTO {
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
