package com.myproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor

@Entity
@Table(name = "inductive_impedance_areas")

public class InductiveImpedanceAreas {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Setter
    @Column(name = "inductive_impedance_areas", nullable = false)
    private double inductiveResistance;

    public InductiveImpedanceAreas(double inductiveResistance) {
        this.inductiveResistance = inductiveResistance;
    }
}