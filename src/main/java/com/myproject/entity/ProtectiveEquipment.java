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
@Table(name = "protective_equipment")
public class ProtectiveEquipment {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "circuit_breaker_type", nullable = false)
    private String circuitBreakerType;
    @Column(name = "thermal_release_rated_current", nullable = false)
    private double thermalReleaseRatedCurrent;
    @Column(name = "electromagnetic_releas_rated_current", nullable = false)
    private double electromagneticReleaseRatedCurrent;
    @Column(name = "circuit_breaker_rated_current", nullable = false)
    private double circuitBreakerRatedCurrent;

    @ManyToOne(cascade = CascadeType.ALL)
    private LowVoltCables lowVoltCables;

}
