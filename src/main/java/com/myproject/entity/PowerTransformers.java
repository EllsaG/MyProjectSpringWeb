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
}
