package com.myproject.controller.dto.startinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;


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

    public long getStartInformId() {
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
