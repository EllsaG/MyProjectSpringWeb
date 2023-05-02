package com.myproject.repositories;

import com.myproject.entity.LowVoltCables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LowVoltCablesRepository
extends JpaRepository<LowVoltCables, Long> {
}
