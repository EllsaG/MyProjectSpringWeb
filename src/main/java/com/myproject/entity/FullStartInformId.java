package com.myproject.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "full_start_inform_id")
public class FullStartInformId {
    @Id
    @Column(name = "f_s_inform_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "full_information_id", nullable = false)
    private Long fullInformationId;
    @Column(name = "start_inform_id", nullable = false)
    private Long startInformId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "power", nullable = false)
    private double power;
    @Column(name = "power_of_group", nullable = false)
    private double powerOfGroup;
    @Column(name = "amount", nullable = false)
    private int amount;
    @Column(name = "k_i", nullable = false)
    private double ki;
    @Column(name = "cos_f", nullable = false)
    private double cosf;
    @Column(name = "tg_f", nullable = false)
    private double tgf;
    @Column(name = "avg_daily_active_power", nullable = false)
    private double avgDailyActivePower;
    @Column(name = "avg_daily_reactive_power", nullable = false)
    private double avgDailyReactivePower;

    public FullStartInformId(Long fullInformationId, Long startInformId, Integer amount) {
        this.fullInformationId = fullInformationId;
        this.startInformId = startInformId;
        this.amount = amount;
    }

    public FullStartInformId(Long fullInformationId, Long startInformId, String name, double power,
                             double powerOfGroup, int amount, double ki, double cosf, double tgf,
                             double avgDailyActivePower, double avgDailyReactivePower) {
        this.fullInformationId = fullInformationId;
        this.startInformId = startInformId;
        this.name = name;
        this.power = power;
        this.powerOfGroup = powerOfGroup;
        this.amount = amount;
        this.ki = ki;
        this.cosf = cosf;
        this.tgf = tgf;
        this.avgDailyActivePower = avgDailyActivePower;
        this.avgDailyReactivePower = avgDailyReactivePower;
    }

    public FullStartInformId() {
    }

    public Long getId() {
        return id;
    }


    public Long getFullInformationId() {
        return fullInformationId;
    }

    public void setFullInformationId(Long fullInformationId) {
        this.fullInformationId = fullInformationId;
    }

    public Long getStartInformId() {
        return startInformId;
    }

    public void setStartInformId(Long startInformId) {
        this.startInformId = startInformId;
    }

    public Integer getAmount() {
        return amount;
    }

    public double getPowerOfGroup() {
        return powerOfGroup;
    }

    public void setPowerOfGroup(double powerOfGroup) {
        this.powerOfGroup = powerOfGroup;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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