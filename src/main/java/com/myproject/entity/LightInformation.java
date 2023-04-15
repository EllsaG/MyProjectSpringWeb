package com.myproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="light_information")
public class LightInformation {
    @Id
    @Column(name="id",nullable = false)
    private long id;

    @Column(name="model_of_luminaire",nullable = false)
    private String modelOfLuminaire;
    @Column(name="model_of_lamp",nullable = false)
    private String modelOfLamp;
    @Column(name="amount_of_luminaires",nullable = false)
    private int amountOfLuminaires;
    @Column(name="amount_of_lamps_in_one_luminaire",nullable = false)
    private int amountOfLampsInOneLuminaire;
    @Column(name="power_of_one_lamp",nullable = false)
    private double powerOfOneLamp;
    @Column(name="light_flux_of_one_lamp",nullable = false)
    private double lightFluxOfOneLamp;
    @Column(name="distance_between_rows_of_lamps",nullable = false)
    private double distanceBetweenRowsOfLamps;
    @Column(name="distance_between_wall_and_first_row_of_lamps",nullable = false)
    private double distanceBetweenWallAndFirstRowOfLamps;
    @Column(name="amount_luminaires_per_length",nullable = false)
    private int amountLuminairesPerLength;
    @Column(name="amount_luminaires_per_width",nullable = false)
    private int amountLuminairesPerWidth;
    @Column(name="active_power",nullable = false)
    private double activePower;
    @Column(name="reactive_power",nullable = false)
    private double reactivePower;
    @Column(name="full_power",nullable = false)
    private double fullPower;
    @Column(name="electric_current",nullable = false)
    private double electricCurrent;
    @Column(name="electric_current_of_one_row_of_luminaire",nullable = false)
    private double electricCurrentOfOneRowOfLuminaire;
    @Column(name = "cos_f", nullable = false)
    private double cosF;
    @Column(name = "tg_f", nullable = false)
    private double tgF;

    public LightInformation(long id, String modelOfLuminaire, String modelOfLamp, int amountOfLuminaires, int amountOfLampsInOneLuminaire,
                            double powerOfOneLamp, double lightFluxOfOneLamp, double distanceBetweenRowsOfLamps, double distanceBetweenWallAndFirstRowOfLamps,
                            int amountLuminairesPerLength, int amountLuminairesPerWidth, double activePower, double reactivePower, double fullPower,
                            double electricCurrent, double electricCurrentOfOneRowOfLuminaire, double cosF, double tgF) {
        this.id = id;
        this.modelOfLuminaire = modelOfLuminaire;
        this.modelOfLamp = modelOfLamp;
        this.amountOfLuminaires = amountOfLuminaires;
        this.amountOfLampsInOneLuminaire = amountOfLampsInOneLuminaire;
        this.powerOfOneLamp = powerOfOneLamp;
        this.lightFluxOfOneLamp = lightFluxOfOneLamp;
        this.distanceBetweenRowsOfLamps = distanceBetweenRowsOfLamps;
        this.distanceBetweenWallAndFirstRowOfLamps = distanceBetweenWallAndFirstRowOfLamps;
        this.amountLuminairesPerLength = amountLuminairesPerLength;
        this.amountLuminairesPerWidth = amountLuminairesPerWidth;
        this.activePower = activePower;
        this.reactivePower = reactivePower;
        this.fullPower = fullPower;
        this.electricCurrent = electricCurrent;
        this.electricCurrentOfOneRowOfLuminaire = electricCurrentOfOneRowOfLuminaire;
        this.cosF = cosF;
        this.tgF = tgF;
    }

    public LightInformation() {

    }
}
