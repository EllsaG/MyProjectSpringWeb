package com.myproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="light_information")
public class LightInformation {
    @Id
    @Column(name="id",nullable = false)
    private long id;

    @Column(name="luminaire_model",nullable = false)
    private String luminaireModel;
    @Column(name="lamp_model",nullable = false)
    private String lampModel;
    @Column(name="amount_of_luminaires",nullable = false)
    private int amountOfLuminaires;
    @Column(name="amount_lamps_in_one_luminaire",nullable = false)
    private int amountLampsInOneLuminaire;
    @Column(name="one_lamp_power",nullable = false)
    private double oneLampPower;
    @Column(name="one_lamp_light_flux",nullable = false)
    private double oneLampLightFlux;
    @Column(name="distance_between_lamp_rows",nullable = false)
    private double distanceBetweenLampRows;
    @Column(name="distance_between_wall_and_first_lamp_row",nullable = false)
    private double distanceBetweenWallAndFirstLampRow;
    @Column(name="amount_luminaires_per_length",nullable = false)
    private int amountLuminairesPerLength;
    @Column(name="amount_luminaires_per_width",nullable = false)
    private int amountLuminairesPerWidth;
    @Column(name="total_active_power",nullable = false)
    private double totalActivePower;
    @Column(name="total_reactive_power",nullable = false)
    private double totalReactivePower;
    @Column(name="total_full_power",nullable = false)
    private double totalFullPower;
    @Column(name="electric_current",nullable = false)
    private double electricCurrent;
    @Column(name="electric_current_of_one_row_of_luminaires",nullable = false)
    private double electricCurrentOfOneRowOfLuminaires;
    @Column(name = "cos_f", nullable = false)
    private double cosF;
    @Column(name = "tg_f", nullable = false)
    private double tgF;


}
