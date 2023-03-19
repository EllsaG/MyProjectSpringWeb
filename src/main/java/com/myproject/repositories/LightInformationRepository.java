package com.myproject.repositories;

import com.myproject.entity.LightInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightInformationRepository extends
        JpaRepository<LightInformation, Long> {
}
