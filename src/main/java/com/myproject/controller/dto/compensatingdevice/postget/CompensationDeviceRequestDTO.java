package com.myproject.controller.dto.compensatingdevice.postget;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompensationDeviceRequestDTO {
    @JsonProperty("id")
    long id;
    @JsonProperty("nameOfCompensationDevice")
    String nameOfCompensationDevice;
    @JsonProperty("powerOfCompensatingDevice")
    double powerOfCompensatingDevice;

    public long getId() {
        return id;
    }

    public String getNameOfCompensationDevice() {
        return nameOfCompensationDevice;
    }

    public double getPowerOfCompensatingDevice() {
        return powerOfCompensatingDevice;
    }
}
