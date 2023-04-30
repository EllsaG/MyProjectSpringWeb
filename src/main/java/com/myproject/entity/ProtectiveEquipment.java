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
    @Column(name = "type_of_circuit_breaker", nullable = false)
    private String typeOfCircuitBreaker;
    @Column(name = "nominal_current_of_thermal_release", nullable = false)
    private double nominalCurrentOfThermalRelease;
    @Column(name = "nominal_current_of_electromagnetic_releas", nullable = false)
    private double nominalCurrentOfElectromagneticRelease;
    @Column(name = "nominal_current_of_circuit_breaker", nullable = false)
    private double nominalCurrentOfCircuitBreaker;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cables_id", nullable = false)
    private Cables cables;

}
