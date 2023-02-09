package com.myproject.repositories;

import com.myproject.entity.FullInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FullInformationRepository
        extends JpaRepository<FullInformation, Long> {
}
