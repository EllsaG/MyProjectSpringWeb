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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "compensation_device_selection")
public class CompensationDeviceSelection {
    @Id
    @Column(name ="id",nullable = false)
    private long id;
    @Column(name = "min_power_of_compensation_device",nullable = false)
    private double minPowerOfCompensatingDevice;
    @Column(name = "max_power_of_compensation_device",nullable = false)
    private double maxPowerOfCompensatingDevice;



}
