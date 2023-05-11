package com.myproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "high_volt_information")
public class HighVoltInformation {

    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "high_voltage_air_line_inductive_resistance", nullable = false)
    private double highVoltageAirLineInductiveResistance;
    @Column(name = "high_voltage_cable_line_inductive_resistance", nullable = false)
    private double highVoltageCableLineInductiveResistance;
    @Column(name = "high_voltage_cable_line_active_resistance", nullable = false)
    private double highVoltageCableLineActiveResistance;
    @Column(name = "surge_coefficient", nullable = false)
    private double surgeCoefficient;
    @Column(name = "economic_current_density", nullable = false)
    private double economicCurrentDensity;
    @Column(name = "fixed_time", nullable = false)
    private double fixedTime ;
    @Column(name = "coefficient_taking_emitted_heat_difference", nullable = false)
    private double coefficientTakingEmittedHeatDifference ;
    @Column(name = "production_hall_transformer_full_power", nullable = false)
    private double productionHallTransformerFullPower;
    @Column(name = "base_voltage", nullable = false)
    private int baseVoltage;
    @Column(name = "base_full_power", nullable = false)
    private int baseFullPower;
    @Column(name = "relative_baseline_unrestricted_power_resistance", nullable = false)
    private double relativeBaselineUnrestrictedPowerResistance;
    @Column(name = "high_voltage_air_line_length", nullable = false)
    private double highVoltageAirLineLength;
    @Column(name = "head_transformer_full_power", nullable = false)
    private double headTransformerFullPower;
    @Column(name = "short_circuit_voltage", nullable = false)
    private double shortCircuitVoltage;
    @Column(name = "cable_line_length", nullable = false)
    private double cableLineLength;
    @Column(name = "rated_voltage_of_higher_voltage_winding_of_transformer", nullable = false)
    private double ratedVoltageOfHigherVoltageWindingOfTransformer;
    @Column(name = "relative_basis_resistance", nullable = false)
    private double relativeBasisResistance;
    @Column(name = "power_line_relative_resistance", nullable = false)
    private double powerLineRelativeResistance;
    @Column(name = "first_transformer_relative_reactive_resistance", nullable = false)
    private double firstTransformerRelativeReactiveResistance;
    @Column(name = "cable_line_relative_reactive_resistance", nullable = false)
    private double cableLineRelativeReactiveResistance;
    @Column(name = "second_transformer_relative_reactive_resistance", nullable = false)
    private double secondTransformerRelativeReactiveResistance;
    @Column(name = "reactive_resistance_at_point_k_1", nullable = false)
    private double reactiveResistanceAtPointK1;
    @Column(name = "base_current_at_point_k_1", nullable = false)
    private double baseCurrentAtPointK1;
    @Column(name = "full_resistance_at_point_k_1", nullable = false)
    private double fullResistanceAtPointK1;
    @Column(name = "short_circuit_current_at_point_k_1", nullable = false)
    private double shortCircuitCurrentAtPointK1;
    @Column(name = "surge_current_at_point_k_1", nullable = false)
    private double surgeCurrentAtPointK1;
    @Column(name = "short_circuit_power_at_point_k_1", nullable = false)
    private double shortCircuitPowerAtPointK1;
    @Column(name = "rated_power_transformer_current", nullable = false)
    private double ratedPowerTransformerCurrent;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InductiveImpedanceAreas> inductiveImpedanceAreas;


}
