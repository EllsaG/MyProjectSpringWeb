package com.myproject.controller.dto.compensatingdevice.update;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompensationDeviceUpdateRequestDTO {

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
