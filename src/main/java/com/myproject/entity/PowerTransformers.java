package com.myproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "power_transformers")
public class PowerTransformers {

    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "model_of_transformer", nullable = false)
    private String modelOfTransformer;
    @Column(name = "full_power_of_transformer", nullable = false)
    private double fullPowerOfTransformer;
    @Column(name = "coef_of_transformer_load", nullable = false)
    private double coefOfTransformerLoad;
    @Column(name = "short_circuit_voltage", nullable = false)
    private double shortCircuitVoltage;
    @Column(name = "idle_losses_of_transformer", nullable = false)
    private double idleLossesOfTransformer;
    @Column(name = "high_side_voltage", nullable = false)
    private double highSideVoltage;
    @Column(name = "low_side_voltage", nullable = false)
    private double lowSideVoltage;
    @Column(name = "short_circuit_losses", nullable = false)
    private double shortCircuitLosses;
    @Column(name = "idle_current", nullable = false)
    private double idleCurrent;


    public PowerTransformers(long id, String modelOfTransformer, double fullPowerOfTransformer,
                             double coefOfTransformerLoad, double shortCircuitVoltage, double idleLossesOfTransformer,
                             double highSideVoltage, double lowSideVoltage, double shortCircuitLosses, double idleCurrent) {
        this.id = id;
        this.modelOfTransformer = modelOfTransformer;
        this.fullPowerOfTransformer = fullPowerOfTransformer;
        this.coefOfTransformerLoad = coefOfTransformerLoad;
        this.shortCircuitVoltage = shortCircuitVoltage;
        this.idleLossesOfTransformer = idleLossesOfTransformer;
        this.highSideVoltage = highSideVoltage;
        this.lowSideVoltage = lowSideVoltage;
        this.shortCircuitLosses = shortCircuitLosses;
        this.idleCurrent = idleCurrent;
    }

    public PowerTransformers() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelOfTransformer() {
        return modelOfTransformer;
    }

    public void setModelOfTransformer(String modelOfTransformer) {
        this.modelOfTransformer = modelOfTransformer;
    }

    public double getFullPowerOfTransformer() {
        return fullPowerOfTransformer;
    }

    public void setFullPowerOfTransformer(double fullPowerOfTransformer) {
        this.fullPowerOfTransformer = fullPowerOfTransformer;
    }

    public double getCoefOfTransformerLoad() {
        return coefOfTransformerLoad;
    }

    public void setCoefOfTransformerLoad(double coefOfTransformerLoad) {
        this.coefOfTransformerLoad = coefOfTransformerLoad;
    }

    public double getShortCircuitVoltage() {
        return shortCircuitVoltage;
    }

    public void setShortCircuitVoltage(double shortCircuitVoltage) {
        this.shortCircuitVoltage = shortCircuitVoltage;
    }

    public double getIdleLossesOfTransformer() {
        return idleLossesOfTransformer;
    }

    public void setIdleLossesOfTransformer(double idleLossesOfTransformer) {
        this.idleLossesOfTransformer = idleLossesOfTransformer;
    }

    public double getHighSideVoltage() {
        return highSideVoltage;
    }

    public void setHighSideVoltage(double highSideVoltage) {
        this.highSideVoltage = highSideVoltage;
    }

    public double getLowSideVoltage() {
        return lowSideVoltage;
    }

    public void setLowSideVoltage(double lowSideVoltage) {
        this.lowSideVoltage = lowSideVoltage;
    }

    public double getShortCircuitLosses() {
        return shortCircuitLosses;
    }

    public void setShortCircuitLosses(double shortCircuitLosses) {
        this.shortCircuitLosses = shortCircuitLosses;
    }

    public double getIdleCurrent() {
        return idleCurrent;
    }

    public void setIdleCurrent(double idleCurrent) {
        this.idleCurrent = idleCurrent;
    }
}
