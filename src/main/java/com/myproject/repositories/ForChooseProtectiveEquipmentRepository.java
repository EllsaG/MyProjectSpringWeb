package com.myproject.repositories;

import com.myproject.entity.ProtectiveEquipmentSelection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForChooseProtectiveEquipmentRepository
extends JpaRepository<ProtectiveEquipmentSelection, Long> {
}
