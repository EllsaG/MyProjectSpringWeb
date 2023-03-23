package com.myproject.entity;

import javax.persistence.*;

@Entity
@Table(name="light_information")
public class LightInformation {
    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
    private Double cosF;
    @Column(name = "tg_f", nullable = false)
    private Double tgF;


    public LightInformation(String modelOfLuminaire, String modelOfLamp, int amountOfLuminaires, int amountOfLampsInOneLuminaire, double powerOfOneLamp, double lightFluxOfOneLamp, double distanceBetweenRowsOfLamps, double distanceBetweenWallAndFirstRowOfLamps, int amountLuminairesPerLength, int amountLuminairesPerWidth, double activePower, double reactivePower, double fullPower, double electricCurrent, double electricCurrentOfOneRowOfLuminaire, Double cosF, Double tgF) {
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

    public Long getId() {
        return id;
    }


    public double getLightFluxOfOneLamp() {
        return lightFluxOfOneLamp;
    }

    public void setLightFluxOfOneLamp(double lightFluxOfOneLamp) {
        this.lightFluxOfOneLamp = lightFluxOfOneLamp;
    }

    public double getPowerOfOneLamp() {
        return powerOfOneLamp;
    }

    public void setPowerOfOneLamp(double powerOfOneLamp) {
        this.powerOfOneLamp = powerOfOneLamp;
    }

    public String getModelOfLuminaire() {
        return modelOfLuminaire;
    }

    public void setModelOfLuminaire(String modelOfLuminaire) {
        this.modelOfLuminaire = modelOfLuminaire;
    }

    public String getModelOfLamp() {
        return modelOfLamp;
    }

    public void setModelOfLamp(String modelOfLamp) {
        this.modelOfLamp = modelOfLamp;
    }

    public double getDistanceBetweenRowsOfLamps() {
        return distanceBetweenRowsOfLamps;
    }

    public void setDistanceBetweenRowsOfLamps(double distanceBetweenRowsOfLamps) {
        this.distanceBetweenRowsOfLamps = distanceBetweenRowsOfLamps;
    }

    public double getDistanceBetweenWallAndFirstRowOfLamps() {
        return distanceBetweenWallAndFirstRowOfLamps;
    }

    public void setDistanceBetweenWallAndFirstRowOfLamps(double distanceBetweenWallAndFirstRowOfLamps) {
        this.distanceBetweenWallAndFirstRowOfLamps = distanceBetweenWallAndFirstRowOfLamps;
    }

    public int getAmountLuminairesPerLength() {
        return amountLuminairesPerLength;
    }

    public void setAmountLuminairesPerLength(int amountLuminairesPerLength) {
        this.amountLuminairesPerLength = amountLuminairesPerLength;
    }

    public int getAmountLuminairesPerWidth() {
        return amountLuminairesPerWidth;
    }

    public void setAmountLuminairesPerWidth(int amountLuminairesPerWidth) {
        this.amountLuminairesPerWidth = amountLuminairesPerWidth;
    }

    public int getAmountOfLuminaires() {
        return amountOfLuminaires;
    }

    public void setAmountOfLuminaires(int amountOfLuminaires) {
        this.amountOfLuminaires = amountOfLuminaires;
    }

    public int getAmountOfLampsInOneLuminaire() {
        return amountOfLampsInOneLuminaire;
    }

    public void setAmountOfLampsInOneLuminaire(int amountOfLampsInOneLuminaire) {
        this.amountOfLampsInOneLuminaire = amountOfLampsInOneLuminaire;
    }

    public double getActivePower() {
        return activePower;
    }

    public void setActivePower(double activePower) {
        this.activePower = activePower;
    }

    public double getReactivePower() {
        return reactivePower;
    }

    public void setReactivePower(double reactivePower) {
        this.reactivePower = reactivePower;
    }

    public double getFullPower() {
        return fullPower;
    }

    public void setFullPower(double fullPower) {
        this.fullPower = fullPower;
    }

    public double getElectricCurrent() {
        return electricCurrent;
    }

    public void setElectricCurrent(double electricCurrent) {
        this.electricCurrent = electricCurrent;
    }

    public double getElectricCurrentOfOneRowOfLuminaire() {
        return electricCurrentOfOneRowOfLuminaire;
    }

    public void setElectricCurrentOfOneRowOfLuminaire(double electricCurrentOfOneRowOfLuminaire) {
        this.electricCurrentOfOneRowOfLuminaire = electricCurrentOfOneRowOfLuminaire;
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


}
