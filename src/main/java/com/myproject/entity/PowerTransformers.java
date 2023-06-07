package com.myproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "power_transformers")
public class PowerTransformers {

    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "transformer_model", nullable = false)
    private String transformerModel;
    @Column(name = "transformer_full_power", nullable = false)
    private double transformerFullPower;
    @Column(name = "transformer_load_coef", nullable = false)
    private double transformerLoadCoef;
    @Column(name = "short_circuit_voltage", nullable = false)
    private double shortCircuitVoltage;
    @Column(name = "transformer_idle_losses", nullable = false)
    private double transformerIdleLosses;
    @Column(name = "high_side_voltage", nullable = false)
    private double highSideVoltage;
    @Column(name = "low_side_voltage", nullable = false)
    private double lowSideVoltage;
    @Column(name = "short_circuit_losses", nullable = false)
    private double shortCircuitLosses;
    @Column(name = "idle_current", nullable = false)
    private double idleCurrent;

}
