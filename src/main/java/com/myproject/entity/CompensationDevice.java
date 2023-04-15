package com.myproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@Entity
@Table(name = "compensation_device")
public class CompensationDevice {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "name_of_compensation_device", nullable = false)
    private String nameOfCompensationDevice;
    @Column(name = "reactive_power_of_compensation_device", nullable = false)
    private double reactivePowerOfCompensationDevice;

    public CompensationDevice(long id, String nameOfCompensationDevice, double reactivePowerOfCompensationDevice) {
        this.id = id;
        this.nameOfCompensationDevice = nameOfCompensationDevice;
        this.reactivePowerOfCompensationDevice = reactivePowerOfCompensationDevice;
    }

    public CompensationDevice() {

    }


}
