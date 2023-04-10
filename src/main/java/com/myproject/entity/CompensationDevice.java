package com.myproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfCompensationDevice() {
        return nameOfCompensationDevice;
    }

    public void setNameOfCompensationDevice(String nameOfCompensationDevice) {
        this.nameOfCompensationDevice = nameOfCompensationDevice;
    }

    public double getReactivePowerOfCompensationDevice() {
        return reactivePowerOfCompensationDevice;
    }

    public void setReactivePowerOfCompensationDevice(double reactivePowerOfCompensationDevice) {
        this.reactivePowerOfCompensationDevice = reactivePowerOfCompensationDevice;
    }
}
