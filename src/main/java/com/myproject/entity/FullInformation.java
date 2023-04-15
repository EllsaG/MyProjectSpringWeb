package com.myproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "full_information")
public class FullInformation {
    @Id
    @Column(name = "full_information_id", nullable = false)
    private long id;
    @Column(name = "name_of_busbar", nullable = false)
    private String nameOfBusbar;
    @Column(name = "amount", nullable = false)
    private int amount;
    @Column(name = "avg_daily_active_power", nullable = false)
    private double avgDailyActivePower;
    @Column(name = "avg_daily_reactive_power", nullable = false)
    private double avgDailyReactivePower;
    @Column(name = "effective_amount_of_equipment")
    private int effectiveAmountOfEquipment;
    @Column(name = "coefficient_max")
    private double coefficientMax;
    @Column(name = "max_active_power")
    private double maxActivePower;
    @Column(name = "max_reactive_power")
    private double maxReactivePower;
    @Column(name = "max_full_power")
    private double maxFullPower;
    @Column(name = "max_electric_current")
    private double maxElectricCurrent;
    @Column(name = "power_of_group", nullable = false)
    private double powerOfGroup;
    @Column(name = "cos_f", nullable = false)
    private double cosF;
    @Column(name = "tg_f", nullable = false)
    private double tgF;
    @Column(name = "k_i", nullable = false)
    private double ki;
    @Column(name = "module", nullable = false)
    private double module;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FullStartInformId> fullStartInformId;

    public FullInformation(long id, String nameOfBusbar, int amount, double avgDailyActivePower,
                           double avgDailyReactivePower, int effectiveAmountOfEquipment, double coefficientMax,
                           double maxActivePower, double maxReactivePower, double maxFullPower, double maxElectricCurrent,
                           double powerOfGroup, double cosF, double tgF, double ki, double module, List<FullStartInformId> fullStartInformId) {
        this.id = id;
        this.nameOfBusbar = nameOfBusbar;
        this.amount = amount;
        this.avgDailyActivePower = avgDailyActivePower;
        this.avgDailyReactivePower = avgDailyReactivePower;
        this.effectiveAmountOfEquipment = effectiveAmountOfEquipment;
        this.coefficientMax = coefficientMax;
        this.maxActivePower = maxActivePower;
        this.maxReactivePower = maxReactivePower;
        this.maxFullPower = maxFullPower;
        this.maxElectricCurrent = maxElectricCurrent;
        this.powerOfGroup = powerOfGroup;
        this.cosF = cosF;
        this.tgF = tgF;
        this.ki = ki;
        this.module = module;
        this.fullStartInformId = fullStartInformId;
    }

    public FullInformation() {
    }


}