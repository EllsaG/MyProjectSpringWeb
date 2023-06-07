package com.myproject.controller.dto.powertransformers.postget;

import com.myproject.entity.TransformerSelection;
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

    List <TransformerSelection> transformerSelectionList;



}
