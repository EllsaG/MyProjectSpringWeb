package com.myproject.controller.dto.compensatingdevice.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CompensationDeviceUpdateRequestDTO {

    @JsonProperty("id")
    long id;
    @JsonProperty("nameOfCompensationDevice")
    String nameOfCompensationDevice;
    @JsonProperty("powerOfCompensatingDevice")
    double powerOfCompensatingDevice;

}
