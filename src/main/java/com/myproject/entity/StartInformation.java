package com.myproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@Entity
@Table(name = "start_information")
public class StartInformation {
    @Id
    @Column(name = "start_inform_Id", nullable = false)
    private long startInformId;
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

    public StartInformation(long startInformId, String name, double power, int amount,
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

}
