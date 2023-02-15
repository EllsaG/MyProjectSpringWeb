package com.myproject.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "full_information")
public class FullInformation {
    @Id
    @Column(name = "busbar_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "full_information_id", nullable = false)
    private StartInformation fullInformation;

    @Column(name = "name_of_busbar", nullable = false)
    private String nameOfBusbar;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "power_of_one", nullable = false)
    private BigDecimal powerOfOne;

    @Column(name = "module")
    private BigDecimal module;

    @Column(name = "cos_f", nullable = false)
    private BigDecimal cosF;

    @Column(name = "tg_f", nullable = false)
    private BigDecimal tgF;

    @Column(name = "\"avg_daily_active_power\"", nullable = false)
    private BigDecimal avgDailyActivePower;

    @Column(name = "\"avg_daily_reactive_power\"", nullable = false)
    private BigDecimal avgDailyReactivePower;

    @Column(name = "effective_amount_of_equipment")
    private BigDecimal effectiveAmountOfEquipment;

    @Column(name = "coefficient_max")
    private BigDecimal coefficientMax;

    @Column(name = "max_active_power")
    private BigDecimal maxActivePower;

    @Column(name = "max_reactive_power")
    private BigDecimal maxReactivePower;

    @Column(name = "max_full_power")
    private BigDecimal maxFullPower;

    @Column(name = "max_electric_current")
    private BigDecimal maxElectricCurrent;

    @Column(name = "power_of_group", nullable = false)
    private BigDecimal powerOfGroup;


    public FullInformation(Long id, StartInformation fullInformation, String nameOfBusbar, Integer amount,
                           BigDecimal powerOfOne, BigDecimal module, BigDecimal cosF, BigDecimal tgF,
                           BigDecimal avgDailyActivePower, BigDecimal avgDailyReactivePower, BigDecimal effectiveAmountOfEquipment,
                           BigDecimal coefficientMax, BigDecimal maxActivePower, BigDecimal maxReactivePower,
                           BigDecimal maxFullPower, BigDecimal maxElectricCurrent, BigDecimal powerOfGroup) {
        this.id = id;
        this.fullInformation = fullInformation;
        this.nameOfBusbar = nameOfBusbar;
        this.amount = amount;
        this.powerOfOne = powerOfOne;
        this.module = module;
        this.cosF = cosF;
        this.tgF = tgF;
        this.avgDailyActivePower = avgDailyActivePower;
        this.avgDailyReactivePower = avgDailyReactivePower;
        this.effectiveAmountOfEquipment = effectiveAmountOfEquipment;
        this.coefficientMax = coefficientMax;
        this.maxActivePower = maxActivePower;
        this.maxReactivePower = maxReactivePower;
        this.maxFullPower = maxFullPower;
        this.maxElectricCurrent = maxElectricCurrent;
        this.powerOfGroup = powerOfGroup;
    }

    public FullInformation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StartInformation getFullInformation() {
        return fullInformation;
    }

    public void setFullInformation(StartInformation fullInformation) {
        this.fullInformation = fullInformation;
    }

    public String getNameOfBusbar() {
        return nameOfBusbar;
    }

    public void setNameOfBusbar(String nameOfBusbar) {
        this.nameOfBusbar = nameOfBusbar;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getPowerOfOne() {
        return powerOfOne;
    }

    public void setPowerOfOne(BigDecimal powerOfOne) {
        this.powerOfOne = powerOfOne;
    }

    public BigDecimal getModule() {
        return module;
    }

    public void setModule(BigDecimal module) {
        this.module = module;
    }

    public BigDecimal getCosF() {
        return cosF;
    }

    public void setCosF(BigDecimal cosF) {
        this.cosF = cosF;
    }

    public BigDecimal getTgF() {
        return tgF;
    }

    public void setTgF(BigDecimal tgF) {
        this.tgF = tgF;
    }

    public BigDecimal getAvgDailyActivePower() {
        return avgDailyActivePower;
    }

    public void setAvgDailyActivePower(BigDecimal avgDailyActivePower) {
        this.avgDailyActivePower = avgDailyActivePower;
    }

    public BigDecimal getAvgDailyReactivePower() {
        return avgDailyReactivePower;
    }

    public void setAvgDailyReactivePower(BigDecimal avgDailyReactivePower) {
        this.avgDailyReactivePower = avgDailyReactivePower;
    }

    public BigDecimal getEffectiveAmountOfEquipment() {
        return effectiveAmountOfEquipment;
    }

    public void setEffectiveAmountOfEquipment(BigDecimal effectiveAmountOfEquipment) {
        this.effectiveAmountOfEquipment = effectiveAmountOfEquipment;
    }

    public BigDecimal getCoefficientMax() {
        return coefficientMax;
    }

    public void setCoefficientMax(BigDecimal coefficientMax) {
        this.coefficientMax = coefficientMax;
    }

    public BigDecimal getMaxActivePower() {
        return maxActivePower;
    }

    public void setMaxActivePower(BigDecimal maxActivePower) {
        this.maxActivePower = maxActivePower;
    }

    public BigDecimal getMaxReactivePower() {
        return maxReactivePower;
    }

    public void setMaxReactivePower(BigDecimal maxReactivePower) {
        this.maxReactivePower = maxReactivePower;
    }

    public BigDecimal getMaxFullPower() {
        return maxFullPower;
    }

    public void setMaxFullPower(BigDecimal maxFullPower) {
        this.maxFullPower = maxFullPower;
    }

    public BigDecimal getMaxElectricCurrent() {
        return maxElectricCurrent;
    }

    public void setMaxElectricCurrent(BigDecimal maxElectricCurrent) {
        this.maxElectricCurrent = maxElectricCurrent;
    }

    public BigDecimal getPowerOfGroup() {
        return powerOfGroup;
    }

    public void setPowerOfGroup(BigDecimal powerOfGroup) {
        this.powerOfGroup = powerOfGroup;
    }

    @Override
    public String toString() {
        return "FullInformation{" +
                "id=" + id +
                ", fullInformation=" + fullInformation +
                ", nameOfBusbar='" + nameOfBusbar + '\'' +
                ", amount=" + amount +
                ", powerOfOne=" + powerOfOne +
                ", module=" + module +
                ", cosF=" + cosF +
                ", tgF=" + tgF +
                ", avgDailyActivePower=" + avgDailyActivePower +
                ", avgDailyReactivePower=" + avgDailyReactivePower +
                ", effectiveAmountOfEquipment=" + effectiveAmountOfEquipment +
                ", coefficientMax=" + coefficientMax +
                ", maxActivePower=" + maxActivePower +
                ", maxReactivePower=" + maxReactivePower +
                ", maxFullPower=" + maxFullPower +
                ", maxElectricCurrent=" + maxElectricCurrent +
                ", powerOfGroup=" + powerOfGroup +
                '}';
    }
}