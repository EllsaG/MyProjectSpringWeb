package com.myproject.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "start_information")
public class StartInformation {
    @Id
    @Column(name = "start_inform_Id", nullable = false)
    private Long startInformId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "power", nullable = false)
    private BigDecimal power;
    @Column(name = "amount", nullable = false)
    private BigInteger amount;
    @Column(name = "k_i", nullable = false)
    private BigDecimal ki;
    @Column(name = "cos_f", nullable = false)
    private BigDecimal cosf;
    @Column(name = "tg_f", nullable = false)
    private BigDecimal tgf;

    public StartInformation(Long startInformId, String name, BigDecimal power, BigInteger amount, BigDecimal ki, BigDecimal cosf, BigDecimal tgf) {
        this.startInformId = startInformId;
        this.name = name;
        this.power = power;
        this.amount = amount;
        this.ki = ki;
        this.cosf = cosf;
        this.tgf = tgf;
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
                '}';
    }
}
