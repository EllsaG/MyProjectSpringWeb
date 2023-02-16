package com.myproject.controller.dto.startinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.entity.StartInformation;

import java.math.BigDecimal;
import java.math.BigInteger;

public class StartInformationResponseDTO {

    private Long startInformId;
    private String name;
    private double power;
    private int amount;
    private double ki;
    private double cosf;
    private double tgf;



    public StartInformationResponseDTO(StartInformation startInformation) {
        startInformId = startInformation.getStartInformId();
        name = startInformation.getName();
        power = startInformation.getPower();
        amount = startInformation.getAmount();
        ki = startInformation.getKi();
        cosf = startInformation.getCosf();
        tgf = startInformation.getTgf();
    }

    public StartInformationResponseDTO(Long startInformId, String name, double power, int amount,
                                       double ki, double cosf, double tgf) {
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

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getKi() {
        return ki;
    }

    public void setKi(double ki) {
        this.ki = ki;
    }

    public double getCosf() {
        return cosf;
    }

    public void setCosf(double cosf) {
        this.cosf = cosf;
    }

    public double getTgf() {
        return tgf;
    }

    public void setTgf(double tgf) {
        this.tgf = tgf;
    }
}
