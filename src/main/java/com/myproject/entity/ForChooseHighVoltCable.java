package com.myproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "for_choose_high_volt_cable")
public class ForChooseHighVoltCable {

    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "min_cable_section_for_choose", nullable = false)
    private double minCableSectionForChoose;

}
