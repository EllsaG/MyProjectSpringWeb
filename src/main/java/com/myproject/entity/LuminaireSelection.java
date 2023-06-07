package com.myproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "luminaire_selection")
public class LuminaireSelection {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "distance_between_lamp_rows")
    private double distanceBetweenLampRows;
    @Column(name = "distance_between_wall_and_first_lamp_row")
    private double distanceBetweenWallAndFirstLampRow;
    @Column(name = "amount_luminaires_per_length")
    private int amountLuminairesPerLength;
    @Column(name = "amount_luminaires_per_width")
    private int amountLuminairesPerWidth;
    @Column(name = "light_flux")
    private double lightFlux;
    @Column(name = "production_hall_height")
    private double productionHallHeight;
    @Column(name = "production_hall_width")
    private double productionHallWidth;
    @Column(name = "production_hall_length")
    private double productionHallLength;

}
