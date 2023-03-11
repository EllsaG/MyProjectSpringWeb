package com.myproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "start_information")
public class StartInformation {
    @Id
    @Column(name = "start_inform_Id", nullable = false)
    private Long startInformId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "power", nullable = false)
    private double power;
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

    public StartInformation(Long startInformId, String name, double power, int amount,
                            double ki, double cosf, double tgf, double avgDailyActivePower,
                            double avgDailyReactivePower) {
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

    public StartInformation() {
    }

    public void setStartInformId(Long startInformId) {
        this.startInformId = startInformId;
    }

    public Long getStartInformId() {
        return startInformId;
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

    @Override
    public String toString() {
        return "StartInformation{" +
                "startInformId=" + startInformId +
                ", name='" + name + '\'' +
                ", power=" + power +
                ", amount=" + amount +
                ", ki=" + ki +
                ", cosf=" + cosf +
                ", tgf=" + tgf +
                ", avgDailyActivePower=" + avgDailyActivePower +
                ", avgDailyReactivePower=" + avgDailyReactivePower +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StartInformation that = (StartInformation) o;
        return Double.compare(that.power, power) == 0 && amount == that.amount && Double.compare(that.ki, ki) == 0 && Double.compare(that.cosf, cosf) == 0 && Double.compare(that.tgf, tgf) == 0 && Double.compare(that.avgDailyActivePower, avgDailyActivePower) == 0 && Double.compare(that.avgDailyReactivePower, avgDailyReactivePower) == 0 && Objects.equals(startInformId, that.startInformId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startInformId, name, power, amount, ki, cosf, tgf, avgDailyActivePower, avgDailyReactivePower);
    }
}
