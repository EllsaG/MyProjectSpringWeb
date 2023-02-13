package com.myproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
public class StartInformation {
    @Id
    private Long startInformId;
    private String name;
    private BigDecimal power;
    private BigInteger amount;

    public StartInformation(Long startInformId, String name, BigDecimal power, BigInteger amount) {
        this.startInformId =startInformId;
        this.name = name;
        this.power = power;
        this.amount = amount;
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

    @Override
    public String toString() {
        return "StartInformation{" +
                "startInformId=" + startInformId +
                ", name='" + name + '\'' +
                ", power=" + power +
                ", amount=" + amount +
                '}';
    }
}
