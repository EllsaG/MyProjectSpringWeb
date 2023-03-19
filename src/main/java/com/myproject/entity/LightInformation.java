package com.myproject.entity;

import javax.persistence.*;

@Entity
@Table(name="light_information")
public class LightInformation {
    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="distance_between_rows_of_lamps",nullable = false)
    private double distanceBetweenRowsOfLamps;
    @Column(name="distance_between_wall_and_first_row_of_lamps",nullable = false)
    private double distanceBetweenWallAndFirstRowOfLamps;
    @Column(name="amount_luminaires_per_length",nullable = false)
    private int amountLuminairesPerLength;
    @Column(name="amount_luminaires_per_width",nullable = false)
    private int amountLuminairesPerWidth;
    @Column(name="light_flux",nullable = false)
    private double lightFlux;
    @Column(name="min_light_flux_for_choose_luminaire",nullable = false)
    private double minLightFluxForChooseLuminaire;
    @Column(name="max_light_flux_for_choose_luminaire",nullable = false)
    private double maxLightFluxForChooseLuminaire;





}
