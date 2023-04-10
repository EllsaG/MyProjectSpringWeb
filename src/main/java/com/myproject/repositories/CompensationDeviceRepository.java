package com.myproject.repositories;

import com.myproject.entity.CompensationDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompensationDeviceRepository
        extends JpaRepository<CompensationDevice, Long> {


}
