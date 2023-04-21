package com.myproject.controller.dto.lightinformation.postget;

import com.myproject.entity.ForChooseLuminaire;
import com.myproject.entity.LightInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class LightInformationCreateNewResponseDTO {

    List<LightInformation> lightInformationList;


}
