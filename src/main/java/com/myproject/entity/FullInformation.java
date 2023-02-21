package com.myproject.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "full_information")
public class FullInformation {
    @Id
    @Column(name = "full_information_id", nullable = false)
    private Long id;
    @Column(name = "name_of_busbar", nullable = false)
    private String nameOfBusbar;
    @Column(name = "amount", nullable = false)
    private Integer amount;
    @Column(name = "avg_daily_active_power", nullable = false)
    private Double avgDailyActivePower;
    @Column(name = "avg_daily_reactive_power", nullable = false)
    private Double avgDailyReactivePower;
    @Column(name = "effective_amount_of_equipment")
    private Integer effectiveAmountOfEquipment;
    @Column(name = "coefficient_max")
    private Double coefficientMax;
    @Column(name = "max_active_power")
    private Double maxActivePower;
    @Column(name = "max_reactive_power")
    private Double maxReactivePower;
    @Column(name = "max_full_power")
    private Double maxFullPower;
    @Column(name = "max_electric_current")
    private Double maxElectricCurrent;
    @Column(name = "power_of_group", nullable = false)
    private Double powerOfGroup;
    @Column(name = "cos_f", nullable = false)
    private Double cosF;
    @Column(name = "tg_f", nullable = false)
    private Double tgF;
    @Column(name = "k_i", nullable = false)
    private Double kI;
    @Column(name = "module", nullable = false)
    private Double module;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FullStartInformId> fullStartInformId;

    public FullInformation(Long id, String nameOfBusbar, Integer amount,
                           Double avgDailyActivePower, Double avgDailyReactivePower, Integer effectiveAmountOfEquipment,
                           Double coefficientMax, Double maxActivePower, Double maxReactivePower, Double maxFullPower,
                           Double maxElectricCurrent, Double powerOfGroup, Double cosF, Double tgF, Double kI, Double module,
                           List<FullStartInformId> fullStartInformId) {
        this.id = id;
        this.nameOfBusbar = nameOfBusbar;
        this.amount = amount;
        this.module = module;
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
        this.kI = kI;
        this.fullStartInformId=fullStartInformId;
    }

    public FullInformation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getModule() {
        return module;
    }

    public void setModule(Double module) {
        this.module = module;
    }

    public Double getAvgDailyActivePower() {
        return avgDailyActivePower;
    }

    public void setAvgDailyActivePower(Double avgDailyActivePower) {
        this.avgDailyActivePower = avgDailyActivePower;
    }

    public Double getAvgDailyReactivePower() {
        return avgDailyReactivePower;
    }

    public void setAvgDailyReactivePower(Double avgDailyReactivePower) {
        this.avgDailyReactivePower = avgDailyReactivePower;
    }

    public Integer getEffectiveAmountOfEquipment() {
        return effectiveAmountOfEquipment;
    }

    public void setEffectiveAmountOfEquipment(Integer effectiveAmountOfEquipment) {
        this.effectiveAmountOfEquipment = effectiveAmountOfEquipment;
    }

    public Double getCoefficientMax() {
        return coefficientMax;
    }

    public void setCoefficientMax(Double coefficientMax) {
        this.coefficientMax = coefficientMax;
    }

    public Double getMaxActivePower() {
        return maxActivePower;
    }

    public void setMaxActivePower(Double maxActivePower) {
        this.maxActivePower = maxActivePower;
    }

    public Double getMaxReactivePower() {
        return maxReactivePower;
    }

    public void setMaxReactivePower(Double maxReactivePower) {
        this.maxReactivePower = maxReactivePower;
    }

    public Double getMaxFullPower() {
        return maxFullPower;
    }

    public void setMaxFullPower(Double maxFullPower) {
        this.maxFullPower = maxFullPower;
    }

    public Double getMaxElectricCurrent() {
        return maxElectricCurrent;
    }

    public void setMaxElectricCurrent(Double maxElectricCurrent) {
        this.maxElectricCurrent = maxElectricCurrent;
    }

    public Double getPowerOfGroup() {
        return powerOfGroup;
    }

    public void setPowerOfGroup(Double powerOfGroup) {
        this.powerOfGroup = powerOfGroup;
    }

    public Double getCosF() {
        return cosF;
    }

    public void setCosF(Double cosF) {
        this.cosF = cosF;
    }

    public Double getTgF() {
        return tgF;
    }

    public void setTgF(Double tgF) {
        this.tgF = tgF;
    }

    public Double getkI() {
        return kI;
    }

    public void setkI(Double kI) {
        this.kI = kI;
    }

    public List<FullStartInformId> getFullStartInformId() {
        return fullStartInformId;
    }

    public void setFullStartInformId(List<FullStartInformId> fullStartInformId) {
        this.fullStartInformId = fullStartInformId;
    }

    @Override
    public String toString() {
        return "FullInformation{" +
                "id=" + id +
                ", nameOfBusbar='" + nameOfBusbar + '\'' +
                ", amount=" + amount +
                ", avgDailyActivePower=" + avgDailyActivePower +
                ", avgDailyReactivePower=" + avgDailyReactivePower +
                ", effectiveAmountOfEquipment=" + effectiveAmountOfEquipment +
                ", coefficientMax=" + coefficientMax +
                ", maxActivePower=" + maxActivePower +
                ", maxReactivePower=" + maxReactivePower +
                ", maxFullPower=" + maxFullPower +
                ", maxElectricCurrent=" + maxElectricCurrent +
                ", powerOfGroup=" + powerOfGroup +
                ", cosF=" + cosF +
                ", tgF=" + tgF +
                ", kI=" + kI +
                ", module=" + module +
                ", fullStartInformId=" + fullStartInformId +
                '}';
    }
}