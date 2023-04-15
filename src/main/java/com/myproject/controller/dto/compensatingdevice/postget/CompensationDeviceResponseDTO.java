package com.myproject.controller.dto.compensatingdevice.postget;

import com.myproject.entity.CompensationDevice;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CompensationDeviceResponseDTO {
    List<CompensationDevice> list;

    public CompensationDeviceResponseDTO(List<CompensationDevice> list) {
        this.list = list;
    }

}
