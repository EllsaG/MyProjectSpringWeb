package com.myproject.controller.dto.lightinformation.postget;

import com.myproject.utils.LightFluxAtAmountOfLamps;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LightInformationChooseLuminariesResponseDTO {

    List<LightFluxAtAmountOfLamps> lightFluxAtAmountOfLampsList;

}
