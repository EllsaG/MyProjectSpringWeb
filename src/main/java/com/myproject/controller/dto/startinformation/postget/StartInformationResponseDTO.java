package com.myproject.controller.dto.startinformation.postget;

import com.myproject.entity.StartInformation;

import java.math.BigDecimal;
import java.math.BigInteger;

public class StartInformationResponseDTO {

    private Long startInformId;
    private String name;
    private BigDecimal power;
    private BigInteger amount;

    public StartInformationResponseDTO(StartInformation startInformation) {
        startInformId = startInformation.getStartInformId();
        name = startInformation.getName();
        power = startInformation.getPower();
        amount = startInformation.getAmount();
    }

    public StartInformationResponseDTO(Long startInformId, String name, BigDecimal power, BigInteger amount) {
        this.startInformId = startInformId;
        this.name = name;
        this.power = power;
        this.amount = amount;
    }

    public Long getStartInformId() {
        return startInformId;
    }

    public void setStartInformId(Long startInformId) {
        this.startInformId = startInformId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPower() {
        return power;
    }

    public void setPower(BigDecimal power) {
        this.power = power;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }
}
