package com.myproject.repositories;

import com.myproject.entity.HighVoltInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HighVoltInformationRepository
extends JpaRepository<HighVoltInformation, Long> {
}
