package com.myproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "full_start_inform_id")
public class FullStartInformId {
    @Id
    @Column(name = "f_s_inform_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "full_information_id", nullable = false)
    private long fullInformationId;
    @Column(name = "start_inform_id", nullable = false)
    private long startInformId;
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

    public FullStartInformId(long fullInformationId, long startInformId, int amount) {
        this.fullInformationId = fullInformationId;
        this.startInformId = startInformId;
        this.amount = amount;
    }

    public FullStartInformId(long fullInformationId, long startInformId, String name, double power,
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

}