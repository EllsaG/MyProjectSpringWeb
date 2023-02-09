package com.myproject.entity;

import com.myproject.entity.StartInformation;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "full_information")
public class FullInformation {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "full_information_id", nullable = false)
    private StartInformation fullInformation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "full_information_name", nullable = false, referencedColumnName = "name")
    private StartInformation fullInformationName;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "power_of_one", nullable = false, referencedColumnName = "power")
    private StartInformation powerOfOne;

    @Column(name = "module")
    private BigDecimal module;

    @Column(name = "cos_f", nullable = false)
    private BigDecimal cosF;

    @Column(name = "tg_f", nullable = false)
    private BigDecimal tgF;

    @Column(name = "active_power", nullable = false)
    private BigDecimal activePower;

    @Column(name = "reactive_power", nullable = false)
    private BigDecimal reactivePower;

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

    public StartInformation getFullInformationName() {
        return fullInformationName;
    }

    public void setFullInformationName(StartInformation fullInformationName) {
        this.fullInformationName = fullInformationName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public StartInformation getPowerOfOne() {
        return powerOfOne;
    }

    public void setPowerOfOne(StartInformation powerOfOne) {
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

    public BigDecimal getActivePower() {
        return activePower;
    }

    public void setActivePower(BigDecimal activePower) {
        this.activePower = activePower;
    }

    public BigDecimal getReactivePower() {
        return reactivePower;
    }

    public void setReactivePower(BigDecimal reactivePower) {
        this.reactivePower = reactivePower;
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

}