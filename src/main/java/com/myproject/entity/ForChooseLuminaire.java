package com.myproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "for_choose_luminaire")
public class ForChooseLuminaire {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "distance_between_rows_of_lamps")
    private double distanceBetweenRowsOfLamps;
    @Column(name = "distance_between_wall_and_first_row_of_lamps")
    private double distanceBetweenWallAndFirstRowOfLamps;
    @Column(name = "amount_luminaires_per_length")
    private int amountLuminairesPerLength;
    @Column(name = "amount_luminaires_per_width")
    private int amountLuminairesPerWidth;
    @Column(name = "light_flux")
    private double lightFlux;

    public ForChooseLuminaire(Long id, double distanceBetweenRowsOfLamps, double distanceBetweenWallAndFirstRowOfLamps, int amountLuminairesPerLength, int amountLuminairesPerWidth, double lightFlux) {
        this.id = id;
        this.distanceBetweenRowsOfLamps = distanceBetweenRowsOfLamps;
        this.distanceBetweenWallAndFirstRowOfLamps = distanceBetweenWallAndFirstRowOfLamps;
        this.amountLuminairesPerLength = amountLuminairesPerLength;
        this.amountLuminairesPerWidth = amountLuminairesPerWidth;
        this.lightFlux = lightFlux;
    }

    public ForChooseLuminaire() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getLightFlux() {
        return lightFlux;
    }

    public void setLightFlux(double lightFlux) {
        this.lightFlux = lightFlux;
    }
}
