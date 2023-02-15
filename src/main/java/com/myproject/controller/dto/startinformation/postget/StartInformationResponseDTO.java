package com.myproject.controller.dto.startinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.entity.StartInformation;

import java.math.BigDecimal;
import java.math.BigInteger;

public class StartInformationResponseDTO {

    private Long startInformId;
    private String name;
    private BigDecimal power;
    private BigInteger amount;
    private BigDecimal ki;
    private BigDecimal cosf;
    private BigDecimal tgf;



    public StartInformationResponseDTO(StartInformation startInformation) {
        startInformId = startInformation.getStartInformId();
        name = startInformation.getName();
        power = startInformation.getPower();
        amount = startInformation.getAmount();
        ki = startInformation.getKi();
        cosf = startInformation.getCosf();
        tgf = startInformation.getTgf();
    }

    public StartInformationResponseDTO(Long startInformId, String name, BigDecimal power, BigInteger amount,
                                       BigDecimal ki, BigDecimal cosf, BigDecimal tgf) {
        this.startInformId = startInformId;
        this.name = name;
        this.power = power;
        this.amount = amount;
        this.ki = ki;
        this.cosf = cosf;
        this.tgf = tgf;
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

    public BigDecimal getKi() {
        return ki;
    }

    public void setKi(BigDecimal ki) {
        this.ki = ki;
    }

    public BigDecimal getCosf() {
        return cosf;
    }

    public void setCosf(BigDecimal cosf) {
        this.cosf = cosf;
    }

    public BigDecimal getTgf() {
        return tgf;
    }

    public void setTgf(BigDecimal tgf) {
        this.tgf = tgf;
    }
}
