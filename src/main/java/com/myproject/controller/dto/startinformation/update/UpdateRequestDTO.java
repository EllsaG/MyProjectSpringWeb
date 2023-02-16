package com.myproject.controller.dto.startinformation.update;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.BigInteger;

public class UpdateRequestDTO {
    @JsonProperty("startInformId")
    private Long startInformId;
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

    public Long getStartInformId() {
        return startInformId;
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public int getAmount() {
        return amount;
    }

    public double getKi() {
        return ki;
    }

    public double getCosf() {
        return cosf;
    }

    public double getTgf() {
        return tgf;
    }
}
