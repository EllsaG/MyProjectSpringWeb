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
@Table(name = "compensation_device")
public class CompensationDevice {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "model_of_compensation_device", nullable = false)
    private String modelOfCompensationDevice;
    @Column(name = "reactive_power_of_compensation_device", nullable = false)
    private double reactivePowerOfCompensationDevice;


}
