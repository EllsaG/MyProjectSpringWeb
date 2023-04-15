package com.myproject.controller.dto.compensatingdevice.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CompensationDeviceRequestDTO {
    @JsonProperty("id")
    long id;
    @JsonProperty("nameOfCompensationDevice")
    String nameOfCompensationDevice;
    @JsonProperty("powerOfCompensatingDevice")
    double powerOfCompensatingDevice;

}
