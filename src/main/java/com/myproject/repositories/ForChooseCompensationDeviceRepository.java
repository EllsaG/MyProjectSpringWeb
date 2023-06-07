package com.myproject.repositories;

import com.myproject.entity.CompensationDeviceSelection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForChooseCompensationDeviceRepository
        extends JpaRepository<CompensationDeviceSelection, Long> {
}
