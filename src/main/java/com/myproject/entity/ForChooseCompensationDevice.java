package com.myproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "for_choose_compensation_device")
public class ForChooseCompensationDevice {
    @Id
    @Column(name ="id",nullable = false)
    private long id;
    @Column(name = "min_power_of_compensation_device",nullable = false)
    private double minPowerOfCompensatingDevice;
    @Column(name = "max_power_of_compensation_device",nullable = false)
    private double maxPowerOfCompensatingDevice;

    public ForChooseCompensationDevice(long id, double minPowerOfCompensatingDevice, double maxPowerOfCompensatingDevice) {
        this.id = id;
        this.minPowerOfCompensatingDevice = minPowerOfCompensatingDevice;
        this.maxPowerOfCompensatingDevice = maxPowerOfCompensatingDevice;
    }

    public ForChooseCompensationDevice() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMinPowerOfCompensatingDevice() {
        return minPowerOfCompensatingDevice;
    }

    public void setMinPowerOfCompensatingDevice(double minPowerOfCompensatingDevice) {
        this.minPowerOfCompensatingDevice = minPowerOfCompensatingDevice;
    }

    public double getMaxPowerOfCompensatingDevice() {
        return maxPowerOfCompensatingDevice;
    }

    public void setMaxPowerOfCompensatingDevice(double maxPowerOfCompensatingDevice) {
        this.maxPowerOfCompensatingDevice = maxPowerOfCompensatingDevice;
    }
}
