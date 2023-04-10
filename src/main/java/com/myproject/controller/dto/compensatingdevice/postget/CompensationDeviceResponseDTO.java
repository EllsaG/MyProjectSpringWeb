package com.myproject.controller.dto.compensatingdevice.postget;

import com.myproject.entity.CompensationDevice;

import java.util.List;

public class CompensationDeviceResponseDTO {
    List<CompensationDevice> list;

    public CompensationDeviceResponseDTO(List<CompensationDevice> list) {
        this.list = list;
    }

    public List<CompensationDevice> getList() {
        return list;
    }

    public void setList(List<CompensationDevice> list) {
        this.list = list;
    }
}
