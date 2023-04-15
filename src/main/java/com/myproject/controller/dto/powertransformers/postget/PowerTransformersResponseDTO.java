package com.myproject.controller.dto.powertransformers.postget;

import com.myproject.entity.CompensationDevice;
import com.myproject.entity.PowerTransformers;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PowerTransformersResponseDTO {
    List<PowerTransformers> list;

    public PowerTransformersResponseDTO(List<PowerTransformers> list) {
        this.list = list;
    }


}
