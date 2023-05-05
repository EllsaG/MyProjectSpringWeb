package com.myproject.controller.dto.highvoltcable.postget;

import com.myproject.entity.ForChooseHighVoltCable;
import com.myproject.entity.HighVoltCables;
import com.myproject.entity.HighVoltInformation;
import com.myproject.entity.LowVoltCables;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ChooseHighVoltCablesResponseDTO {
List<ForChooseHighVoltCable> highVoltCables;
}
