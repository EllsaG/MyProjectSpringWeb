package com.myproject.controller.dto.powertransformers.postget;

import com.myproject.entity.CompensationDevice;
import com.myproject.entity.ForChooseTransformers;
import com.myproject.entity.PowerTransformers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class PowerTransformersResponseDTO {
    List<PowerTransformers> powerTransformersList;

    List <ForChooseTransformers> forChooseTransformersList;



}
