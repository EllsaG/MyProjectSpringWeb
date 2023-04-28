package com.myproject.controller.dto.protectiveequipment.postget;

import com.myproject.entity.ForChooseProtectiveEquipment;
import com.myproject.entity.ProtectiveEquipment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProtectiveEquipmentResponseDTO {
    List<ProtectiveEquipment> protectiveEquipmentList;
    List<ForChooseProtectiveEquipment> forChooseProtectiveEquipmentList;
}
