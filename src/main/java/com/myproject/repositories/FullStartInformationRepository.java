package com.myproject.repositories;

import com.myproject.entity.FullStartInformId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FullStartInformationRepository
        extends JpaRepository<FullStartInformId, Long>{
}
