package com.myproject.controller.dto.update;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.BigInteger;

public class UpdateRequestDTO {
    private Long startInformId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("power")
    private BigDecimal power;
    @JsonProperty("amount")
    private BigInteger amount;

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
}
