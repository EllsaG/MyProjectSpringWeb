package com.myproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "protective_equipment_selection")
public class ProtectiveEquipmentSelection {

    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "equipment_rated_current", nullable = false)
    private double equipmentRatedCurrent;
    @Column(name = "equipment_starting_current", nullable = false)
    private double equipmentStartingCurrent;
    @Column(name = "calculated_current_of_thermal_release", nullable = false)
    private double calculatedCurrentOfThermalRelease;
    @Column(name = "calculated_current_of_electromagnetic_release", nullable = false)
    private double calculatedCurrentOfElectromagneticRelease;






}
