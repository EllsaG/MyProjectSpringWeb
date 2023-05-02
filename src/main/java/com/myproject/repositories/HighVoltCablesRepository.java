package com.myproject.repositories;

import com.myproject.entity.HighVoltCables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HighVoltCablesRepository
extends JpaRepository<HighVoltCables, Long> {
}
