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
@Table(name = "for_choose_protective_equipment")
public class ForChooseProtectiveEquipment {

    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "nominal_current_of_equipment", nullable = false)
    private double nominalCurrentOfEquipment;
    @Column(name = "starting_current_of_equipment", nullable = false)
    private double startingCurrentOfEquipment;
    @Column(name = "calculated_current_of_thermal_release", nullable = false)
    private double calculatedCurrentOfThermalRelease;
    @Column(name = "calculated_current_of_electromagnetic_release", nullable = false)
    private double calculatedCurrentOfElectromagneticRelease;






}
