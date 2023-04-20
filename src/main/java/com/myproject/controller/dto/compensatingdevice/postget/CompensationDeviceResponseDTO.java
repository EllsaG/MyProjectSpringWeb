package com.myproject.controller.dto.compensatingdevice.postget;

import com.myproject.entity.CompensationDevice;
import com.myproject.entity.ForChooseCompensationDevice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class CompensationDeviceResponseDTO {
    List<CompensationDevice> compensationDeviceList;
    List<ForChooseCompensationDevice> forChooseCompensationDeviceList;



}
