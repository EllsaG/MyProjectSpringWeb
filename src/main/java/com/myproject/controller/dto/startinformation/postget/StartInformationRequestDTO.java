package com.myproject.controller.dto.startinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.math.BigInteger;

public class StartInformationRequestDTO {
    @JsonProperty("startInformId")
    private Long startInformId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("power")
    private BigDecimal power;
    @JsonProperty("amount")
    private BigInteger amount;
    @JsonProperty("ki")
    private BigDecimal ki;
    @JsonProperty("cosf")
    private BigDecimal cosf;
    @JsonProperty("tgf")
    private BigDecimal tgf;

    public Long getStartInformId() {
        return startInformId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPower() {
        return power;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public BigDecimal getKi() {
        return ki;
    }

    public BigDecimal getCosf() {
        return cosf;
    }

    public BigDecimal getTgf() {
        return tgf;
    }
}
