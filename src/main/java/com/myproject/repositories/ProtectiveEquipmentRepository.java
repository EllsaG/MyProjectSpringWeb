package com.myproject.repositories;

import com.myproject.entity.ProtectiveEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProtectiveEquipmentRepository
        extends JpaRepository<ProtectiveEquipment, Long> {
}
