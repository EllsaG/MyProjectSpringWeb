package com.myproject.controller.dto.highvoltcable.postget;

import com.myproject.entity.HighVoltCableSelection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ChooseHighVoltCablesResponseDTO {
List<HighVoltCableSelection> highVoltCables;
}
