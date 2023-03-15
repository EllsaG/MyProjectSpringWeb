package com.myproject.controller.dto.startinformation.postget;

import com.myproject.entity.StartInformation;

import java.util.List;

public class StartInformationResponseDTO {

    private Long startInformId;
    private String name;
    private double power;
    private int amount;
    private double ki;
    private double cosf;
    private double tgf;
    private double avgDailyActivePower;
    private double avgDailyReactivePower;
    private List<StartInformation>list;



    public StartInformationResponseDTO(StartInformation startInformation) {
        startInformId = startInformation.getStartInformId();
        name = startInformation.getName();
        power = startInformation.getPower();
        amount = startInformation.getAmount();
        ki = startInformation.getKi();
        cosf = startInformation.getCosf();
        tgf = startInformation.getTgf();
        avgDailyActivePower = startInformation.getAvgDailyActivePower();
        avgDailyReactivePower = startInformation.getAvgDailyReactivePower();

    }
    public StartInformationResponseDTO(List<StartInformation>list) {
        this.list = list;
    }

    public StartInformationResponseDTO(Long startInformId, String name, double power, int amount,
                                       double ki, double cosf, double tgf, double avgDailyActivePower, double avgDailyReactivePower) {
        this.startInformId = startInformId;
        this.name = name;
        this.power = power;
        this.amount = amount;
        this.ki = ki;
        this.cosf = cosf;
        this.tgf = tgf;
        this.avgDailyActivePower = avgDailyActivePower;
        this.avgDailyReactivePower = avgDailyReactivePower;
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

    public double getAvgDailyActivePower() {
        return avgDailyActivePower;
    }

    public void setAvgDailyActivePower(double avgDailyActivePower) {
        this.avgDailyActivePower = avgDailyActivePower;
    }

    public double getAvgDailyReactivePower() {
        return avgDailyReactivePower;
    }

    public void setAvgDailyReactivePower(double avgDailyReactivePower) {
        this.avgDailyReactivePower = avgDailyReactivePower;
    }
}
