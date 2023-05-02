package com.myproject.controller.dto.highvoltcable.postget;

import com.myproject.entity.ForChooseHighVoltCable;
import com.myproject.entity.HighVoltInformation;
import com.myproject.entity.InductiveImpedanceAreas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class HighVoltCablesResponseDTO {
List<HighVoltInformation> highVoltInformationList;
List<ForChooseHighVoltCable> forChooseHighVoltCableList;
}
